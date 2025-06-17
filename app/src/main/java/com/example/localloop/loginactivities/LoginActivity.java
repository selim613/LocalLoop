package com.example.localloop.loginactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.localloop.R;

import com.example.localloop.entities.Organizer;
import com.example.localloop.entities.Participant;
import com.example.localloop.entities.User;
import com.google.firebase.auth.FirebaseAuth;
import com.example.localloop.entities.Admin;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class LoginActivity extends AppCompatActivity {
    private EditText emailInput, passwordInput;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        emailInput = findViewById(R.id.editTextEmailLogin);
        passwordInput = findViewById(R.id.editTextPasswordLogin);
        Button loginButton = findViewById(R.id.buttonLogin);
        Button createAccountButton = findViewById(R.id.buttonCreateAccount);

        loginButton.setOnClickListener(v -> loginUser());
        createAccountButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void loginUser() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        // Checks if the input fields are valid (not empty)
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter your credentials.", Toast.LENGTH_SHORT).show();
            return;
        } else if (email.equals("admin") && password.equals("1")) {  // *** change to XPI76SZUqyCjVxgnUjm0 later ***
            Toast.makeText(this, "Admin login successful!", Toast.LENGTH_SHORT).show();

            Admin admin = new Admin("Admin", "admin");
            createWelcomeMessageIntent(admin);
            return;
        } else { // Either organizer or participant login, firebase firestore database will check the user role
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();

                    FirebaseUser user = mAuth.getCurrentUser();

                    if (user != null) {
                        // Gets the user via their email as an identifier, since firebase authentication is using email + password
                        fetchUserByEmail(user.getEmail(), new Helper() {
                            @Override
                            public void onUserFetched(User user1) {
                                createWelcomeMessageIntent(user1);
                            }

                            @Override
                            public void onError(String errorMessage) {
                                Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // Fetches the user's information (name and role) using their email as the access point
    public void fetchUserByEmail(String email, Helper callback) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users").whereEqualTo("Email", email).get().addOnSuccessListener(querySnapshot -> {
            if (!querySnapshot.isEmpty()) {
                for (QueryDocumentSnapshot doc : querySnapshot) {
                    String name = doc.getString("Name");
                    String role = doc.getString("Role");
                    Log.d("DEBUGGG", "NAME: " + name + " ROLE: " + role);

                    User user1;
                    if ("Organizer".equals(role)) {
                        user1 = new Organizer(name);
                    } else {
                        user1 = new Participant(name);
                    }

                    callback.onUserFetched(user1);
                    return; // Only process first match
                }
            } else {
                callback.onError("No user found with this email.");
            }
        }).addOnFailureListener(e -> {
            callback.onError("Error fetching user: " + e.getMessage());
        });
    }

    public void createWelcomeMessageIntent(User user) {
        Intent intent;

        String welcomeMessage = "Welcome " + user.getName() + "! You are logged in as " + user.getRole() + ".";

        if (user instanceof Organizer) {
            intent = new Intent(this, com.example.localloop.useractivities.organizeractivities.Home.class);
        } else if (user instanceof Participant) {
            intent = new Intent(this, com.example.localloop.useractivities.participantactivities.Home.class);
        } else if (user instanceof Admin) {
            intent = new Intent(this, com.example.localloop.useractivities.adminactivities.Home.class);
        } else {
            return; // This outcome isn't possible
        }

        intent.putExtra("welcomeMessage", welcomeMessage);
        startActivity(intent);
        finish();
    }
}
