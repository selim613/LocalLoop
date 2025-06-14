package com.example.localloop;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView welcomeText = findViewById(R.id.textViewWelcomeMessage);

        // *** Double check ***
        String welcomeMessage = getIntent().getStringExtra("welcomeMessage");

        welcomeText.setText(welcomeMessage);
    }
}
