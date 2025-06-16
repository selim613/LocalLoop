package com.example.localloop.loginactivities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.localloop.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Map;
import java.util.HashMap;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;


public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText nameInput, emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase
        mAuth = FirebaseAuth.getInstance();

        // Initialize Firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        nameInput = findViewById(R.id.editTextName);
        emailInput = findViewById(R.id.editTextEmail);
        passwordInput = findViewById(R.id.editTextPassword);
        Button registerButton = findViewById(R.id.buttonRegister);

        registerButton.setOnClickListener(v -> registerUser(db));
    }

    private void registerUser(FirebaseFirestore db) {
        String name = nameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter valid credentials.", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(this, "User registered successfully!", Toast.LENGTH_SHORT).show();

                // *** if user is signed up succesfully, store their info in firestore here ***
                Map<String, Object> user = new HashMap<>();
                user.put("Name", name);
                user.put("Email", email);

                // Add a new document with a generated ID
                db.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Added with ID: " + documentReference.getId(), Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error adding document: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                Toast.makeText(this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getName() {
        //return Str(nameInput);
        return " ";
    }
}
