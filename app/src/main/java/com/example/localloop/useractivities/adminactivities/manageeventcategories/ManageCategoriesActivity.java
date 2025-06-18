package com.example.localloop.useractivities.adminactivities.manageeventcategories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;
import java.util.List;
import java.util.Map;
import com.example.localloop.R;
import com.example.localloop.helpers.*;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ManageCategoriesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_categories);

        LinearLayout categoryListLayout = findViewById(R.id.categoryListLayout);

        Button addCategoryButton = findViewById(R.id.buttonAddCategory);
        //Button editCategoryButton = findViewById(R.id.buttonEditCategory);
        //Button deleteCategoryButton = findViewById(R.id.buttonDeleteCategory);

        addCategoryButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddCategoryActivity.class);
            startActivity(intent);
        });

        /*editCategoryButton.setOnClickListener(v -> {

        });

        deleteCategoryButton.setOnClickListener(v -> {

        });*/

        // Fetches the categories from the "categories" collection in the firestore database
        Firebase.fetchAllCategories(new Firebase.CategoryListCallback() {
            @Override
            public void onCategoryListFetched(List<Map<String, String>> categories) {
                categoryListLayout.removeAllViews();

                for (Map<String, String> category : categories) {
                    String name = category.get("Name");
                    String description = category.get("Description");

                    TextView categoryView = new TextView(ManageCategoriesActivity.this);
                    categoryView.setText("Name: " + name + "\nDescription: " + description);
                    categoryView.setTextSize(16);
                    categoryView.setPadding(24, 24, 24, 24);
                    categoryView.setTextColor(android.graphics.Color.BLACK); // Black text
                    categoryView.setBackgroundColor(android.graphics.Color.parseColor("#EEEEEE"));

                    LinearLayout.LayoutParams categoryParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    categoryParams.setMargins(0, 0, 0, 32);
                    categoryView.setLayoutParams(categoryParams);

                    // Upon clicking
                    categoryView.setOnClickListener(v -> {
                        new android.app.AlertDialog.Builder(ManageCategoriesActivity.this).setTitle("Manage Category")
                                .setMessage("What do you want to do with \"" + name + "\"?")
                                .setPositiveButton("Edit", (dialog, which) -> {
                                    // edit functionality, get firebase helper?
                                }).setNegativeButton("Delete", (dialog, which) -> {
                                    // delete fucntionality """"""""
                                })
                                .setNeutralButton("Cancel", null)
                                .show();
                    });

                    categoryListLayout.addView(categoryView);
                    categoryListLayout.addView(Divider.create(ManageCategoriesActivity.this));
                }

            }

            @Override
            public void onError(String error) {
                Toast.makeText(ManageCategoriesActivity.this, "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
