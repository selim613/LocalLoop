package com.example.localloop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.localloop.activities.AdminDashboardActivity;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.example.localloop.entities.Admin;

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
        String name, role;
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        String welcomeMessage;

        // Checks if the input fields are valid (not empty)
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter your credentials.", Toast.LENGTH_SHORT).show();
            return;
        } else if (email.equals("admin") && password.equals("1")) {  // *** change to XPI76SZUqyCjVxgnUjm0 later ***
            Toast.makeText(this, "Admin login successful!", Toast.LENGTH_SHORT).show();

            Admin admin = new Admin("Admin","admin");
            welcomeMessage = createWelcomeMessage(admin.getName(), admin.getRole());

            Intent intent = new Intent(this, AdminDashboardActivity.class);
            intent.putExtra("welcomeMessage", welcomeMessage);
            startActivity(intent);
            finish();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                    // Create instance of user?
                });
    }

    public String createWelcomeMessage(String name, String role) {
        return "Welcome " + name + "! You are logged in is " + role + ".";
    }
}
