package com.example.localloop.useractivities.adminactivities.manageuseraccounts.listusersactivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

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
                for (int x = 0; x < users.size(); x++) {
                    Map<String, String> user = users.get(x);
                    //Log.d("TEST LIST", user.get("Name") + user.get("Email") + user.get("Role")); *** works ***
                }
                // *** Add view user list functionality here ***
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ListUsersActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
