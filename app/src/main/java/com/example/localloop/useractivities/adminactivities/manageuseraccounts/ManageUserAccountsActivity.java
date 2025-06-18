package com.example.localloop.useractivities.adminactivities.manageuseraccounts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localloop.R;
import com.example.localloop.useractivities.adminactivities.manageuseraccounts.deleteordisable.DeleteOrDisableActivity;
import com.example.localloop.useractivities.adminactivities.manageuseraccounts.listusersactivity.ListUsersActivity;

public class ManageUserAccountsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user_accounts);

        Button buttonViewUserList = findViewById(R.id.buttonViewUserList);
        Button buttonDeleteOrDisableUser = findViewById(R.id.buttonDeleteOrDisableUser);

        buttonViewUserList.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListUsersActivity.class);
            startActivity(intent);
        });

        buttonDeleteOrDisableUser.setOnClickListener(v -> {
            Intent intent = new Intent(this, DeleteOrDisableActivity.class);
            startActivity(intent);
        });
    }

}
