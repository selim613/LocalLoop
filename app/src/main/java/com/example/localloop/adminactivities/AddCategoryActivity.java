package com.example.localloop.adminactivities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.localloop.events.Category;
import com.example.localloop.R;

public class AddCategoryActivity extends AppCompatActivity {
    private EditText editTextCategoryName;
    private EditText editTextCategoryDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        editTextCategoryName = findViewById(R.id.editTextCategoryName);
        editTextCategoryDescription = findViewById(R.id.editTextCategoryDescription);
        Button buttonSubmitCategory = findViewById(R.id.buttonSubmitCategory);

        buttonSubmitCategory.setOnClickListener(v -> {
            String name = editTextCategoryName.getText().toString().trim();
            String description = editTextCategoryDescription.getText().toString().trim();

            // Add error handling to check if either the category name or description is an empty string (thus invalid)

            Category category = new Category(name, description);
        });
    }
}
