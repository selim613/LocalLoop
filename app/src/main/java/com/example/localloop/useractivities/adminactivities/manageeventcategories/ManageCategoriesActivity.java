package com.example.localloop.useractivities.adminactivities.manageeventcategories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.localloop.R;
import com.example.localloop.helpers.Divider;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ManageCategoriesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_categories);

        LinearLayout categoryListLayout = findViewById(R.id.categoryListLayout);

        Button addCategoryButton = findViewById(R.id.buttonAddCategory);
        Button editCategoryButton = findViewById(R.id.buttonEditCategory);
        Button deleteCategoryButton = findViewById(R.id.buttonDeleteCategory);

        addCategoryButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddCategoryActivity.class);
            startActivity(intent);
        });

        editCategoryButton.setOnClickListener(v -> {

        });

        deleteCategoryButton.setOnClickListener(v -> {

        });

        for (int x = 1; x <= 20; x++) {
            TextView categoryView = new TextView(this);
            categoryView.setText("TEST FOR LOOP: " + x);
            categoryView.setTextSize(16);
            categoryView.setPadding(16, 16, 16, 16);

            LinearLayout.LayoutParams categoryParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            categoryParams.setMargins(0, 0, 0, 24);
            categoryView.setLayoutParams(categoryParams);

            categoryListLayout.addView(categoryView);

            // After every user, a divider is shown to help separate information between different users
            categoryListLayout.addView(Divider.create(this));
        }
    }
}
