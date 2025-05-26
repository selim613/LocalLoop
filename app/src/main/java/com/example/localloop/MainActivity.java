package com.example.localloop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editUsername, editPassword;
    private Spinner spinnerRole;
    private Button buttonLogin, buttonRegister;

    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "Admin123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        spinnerRole = findViewById(R.id.spinnerRole);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        String[] roles = {"Admin", "Organizer", "Participant"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRole.setAdapter(adapter);

        buttonLogin.setOnClickListener(v -> {
            String username = editUsername.getText().toString().trim();
            String password = editPassword.getText().toString().trim();
            String role = spinnerRole.getSelectedItem().toString();

            if (role.equals("Admin")) {
                if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                    navigateToWelcome(username, role);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Admin credentials", Toast.LENGTH_SHORT).show();
                }
            } else {
                // TODO: Check Firebase/SQLite for Organizer/Participant login
                Toast.makeText(MainActivity.this, "Login for " + role + " not yet implemented", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });
    }

    private void navigateToWelcome(String firstname, String role) {
        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
        intent.putExtra("firstname", firstname);
        intent.putExtra("role", role);
        startActivity(intent);
    }
}