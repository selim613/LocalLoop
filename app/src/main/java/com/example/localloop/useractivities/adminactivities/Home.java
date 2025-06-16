package com.example.localloop.useractivities.adminactivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.localloop.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        String welcomeMessage = getIntent().getStringExtra("welcomeMessage");
        TextView welcomeText = findViewById(R.id.textViewDashboardMessage);
        welcomeText.setText(welcomeMessage);

        Button manageCategoriesButton = findViewById(R.id.buttonManageCategories);
        manageCategoriesButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ManageCategoriesActivity.class);
            startActivity(intent);
        });
    }
}
