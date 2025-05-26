package com.example.localloop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editFirstName, editUsername, editPassword;
    private Spinner spinnerRole;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editFirstName = findViewById(R.id.editFirstName);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        spinnerRole = findViewById(R.id.spinnerRole);
        buttonRegister = findViewById(R.id.buttonRegister);

        String[] roles = {"Organizer", "Participant"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRole.setAdapter(adapter);

        buttonRegister.setOnClickListener(v -> {
            String firstname = editFirstName.getText().toString().trim();
            String username = editUsername.getText().toString().trim();
            String password = editPassword.getText().toString().trim();
            String role = spinnerRole.getSelectedItem().toString();

            // TODO: Save user to Firebase or SQLite
            Toast.makeText(this, "User " + firstname + " registered as " + role, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
        });
    }
}