package com.example.localloop.activities;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.localloop.R;
import com.example.localloop.entities.Admin;
import com.example.localloop.events.Category;
import android.widget.TextView;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        String welcomeMessage = getIntent().getStringExtra("welcomeMessage");
        TextView welcomeText = findViewById(R.id.textViewDashboardMessage);
        welcomeText.setText(welcomeMessage);

        Category testCategory = new Category("Sports", "Competitive and recreational events");
        Log.d("ADMIN_ACTION", "Created category: " + testCategory.getName() + " - " + testCategory.getDescription());
    }
}
