package com.example.localloop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private Button loginButton, createAccountButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        emailInput = findViewById(R.id.editTextEmailLogin);
        passwordInput = findViewById(R.id.editTextPasswordLogin);
        loginButton = findViewById(R.id.buttonLogin);
        createAccountButton = findViewById(R.id.buttonCreateAccount);

        loginButton.setOnClickListener(v -> loginUser());
        createAccountButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void loginUser() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        String firstName;
        String role;
        String welcomeMessage;

        // Checks if the input fields are valid (not empty)
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter your credentials.", Toast.LENGTH_SHORT).show();
            return;
        } else if (email.equals("admin") && password.equals("t3st")) {  // *** change to XPI76SZUqyCjVxgnUjm0 later ***
            Toast.makeText(this, "Admin login successful!", Toast.LENGTH_SHORT).show();

            firstName = "admin";
            role = "admin";
            welcomeMessage = "Welcome " + firstName + "! You are logged in as \"" + role + "\".";
            // System.out.println(welcomeMessage);

            Intent intent = new Intent(this, WelcomeActivity.class);
            intent.putExtra("welcomeMessage", welcomeMessage);
            startActivity(intent);
            finish();

            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
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
}
