package com.example.localloop.useractivities.adminactivities.manageuseraccounts.listusersactivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import com.example.localloop.R;
import com.example.localloop.firebasehelpers.Firebase;
import java.util.List;
import java.util.Map;

public class ListUsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users_list);
        LinearLayout userListContainer = findViewById(R.id.userListContainer);

        Firebase.fetchAllUsers(new Firebase.UserListCallback() {
            @Override
            public void onUserListFetched(List<Map<String, String>> users) {
                userListContainer.removeAllViews(); // Clears previous
                for (int x = 0; x < users.size(); x++) {
                    Map<String, String> user = users.get(x);
                    // Log.d("TEST LIST", user.get("Name") + user.get("Email") + user.get("Role"));

                    android.widget.TextView textViewName = new android.widget.TextView(ListUsersActivity.this);
                    android.widget.TextView textViewEmail = new android.widget.TextView(ListUsersActivity.this);
                    android.widget.TextView textViewRole = new android.widget.TextView(ListUsersActivity.this);

                    textViewName.setText("Name: " + user.get("Name") + "\nEmail: " + user.get("Email") + "\nRole: " + user.get("Role"));
                    textViewName.setTextSize(16);
                    textViewName.setPadding(16, 16, 16, 16);
                    userListContainer.addView(textViewName);

                    /*textViewEmail.setText("Email: " + user.get("Email"));
                    textViewEmail.setTextSize(16);
                    textViewEmail.setPadding(16, 16, 16, 16);
                    userListContainer.addView(textViewEmail);

                    textViewRole.setText("Role: " + user.get("Role"));
                    textViewRole.setTextSize(16);
                    textViewRole.setPadding(16, 16, 16, 16);
                    userListContainer.addView(textViewRole);*/

                    // After every user, a divider is shown to help separate information between different users
                    View divider = new View(ListUsersActivity.this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, 2
                    );

                    params.setMargins(0, 8, 0, 8);
                    divider.setLayoutParams(params);
                    divider.setBackgroundColor(ContextCompat.getColor(ListUsersActivity.this, android.R.color.darker_gray));
                    userListContainer.addView(divider);
                }
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ListUsersActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
