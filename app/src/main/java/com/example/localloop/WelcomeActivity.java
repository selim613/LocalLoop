package com.example.localloop;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String firstname = getIntent().getStringExtra("firstname");
        String role = getIntent().getStringExtra("role");

        TextView textWelcome = findViewById(R.id.textWelcome);
        textWelcome.setText("Welcome " + firstname + "! You are logged in as \"" + role + "\".");
    }
}