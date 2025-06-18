package com.example.localloop.useractivities.adminactivities.manageuseraccounts.deleteordisable;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localloop.R;
import com.example.localloop.helpers.Firebase;

import java.util.List;
import java.util.Map;

public class DeleteOrDisableActivity extends AppCompatActivity {

    LinearLayout userListContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteordisable_account);

        userListContainer = findViewById(R.id.userListContainer);

        // Calls the helper method from the Firebase class, it allows access to all of the users
        Firebase.fetchAllUsers(new Firebase.UserListCallback() {
            @Override
            public void onUserListFetched(List<Map<String, String>> users) {
                for (Map<String, String> user : users) {
                    // Goes through all of the users and displays them to the screen (activity_deleteordisable_account.xml)
                    String name = user.get("Name");
                    String email = user.get("Email");
                    String role = user.get("Role");

                    TextView userView = new TextView(DeleteOrDisableActivity.this);
                    userView.setText("Name: " + name + "\nEmail: " + email + "\nRole: " + role);
                    userView.setPadding(24, 24, 24, 24);
                    userView.setTextSize(16f);
                    userView.setBackgroundColor(Color.parseColor("#EEEEEE"));

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    );
                    params.setMargins(0, 0, 0, 32);
                    userView.setLayoutParams(params);

                    // If the admin clicks on one of the users, the alert dialog will pop up for confirmation that they want to delete that user
                    userView.setOnClickListener(v -> {
                        new AlertDialog.Builder(DeleteOrDisableActivity.this)
                                .setTitle("Confirm Delete").setMessage("Are you sure you want to delete " + name + "?")
                                .setPositiveButton("Delete", (dialog, which) -> {
                                    Firebase.deleteUser(email, new Firebase.UserFetchCallback() {
                                        @Override
                                        public void onSuccess(com.example.localloop.entities.User u) {
                                            Toast.makeText(DeleteOrDisableActivity.this, "User " + name + " has been deleted.", Toast.LENGTH_SHORT).show();
                                            userListContainer.removeView(userView);
                                        }

                                        @Override
                                        public void onError(String errorMessage) {
                                            Toast.makeText(DeleteOrDisableActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                })
                                .setNegativeButton("Cancel", null).show();
                    });
                    userListContainer.addView(userView);
                }
            }

            @Override
            public void onError(String error) {
                Toast.makeText(DeleteOrDisableActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
