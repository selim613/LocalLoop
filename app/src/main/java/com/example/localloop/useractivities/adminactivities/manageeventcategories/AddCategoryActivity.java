package com.example.localloop.useractivities.adminactivities.manageeventcategories;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.localloop.events.Category;
import com.example.localloop.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddCategoryActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText editTextCategoryName;
    private EditText editTextCategoryDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        // Initialize Firebase
        mAuth = FirebaseAuth.getInstance();

        // Initialize Firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        editTextCategoryName = findViewById(R.id.editTextCategoryName);
        editTextCategoryDescription = findViewById(R.id.editTextCategoryDescription);
        Button buttonSubmitCategory = findViewById(R.id.buttonSubmitCategory);

        buttonSubmitCategory.setOnClickListener(v -> {
            String name = editTextCategoryName.getText().toString().trim();
            String description = editTextCategoryDescription.getText().toString().trim();

            if (name.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill out both fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Category category = new Category(name, description);

            // here??
        });
    }
}
