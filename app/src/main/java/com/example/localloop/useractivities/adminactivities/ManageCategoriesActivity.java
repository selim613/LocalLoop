package com.example.localloop.useractivities.adminactivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.localloop.R;

public class ManageCategoriesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_categories);

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
    }
}
