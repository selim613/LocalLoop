package com.example.localloop.organizeractivities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.localloop.R;

import android.widget.TextView;

public class OrganizerDashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        String welcomeMessage = getIntent().getStringExtra("welcomeMessage");
        TextView welcomeText = findViewById(R.id.textViewDashboardMessage);
        welcomeText.setText(welcomeMessage);



    }
}
