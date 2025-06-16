package com.example.localloop.loginactivities;

import com.example.localloop.entities.User;

public interface Callback {
    void onUserFetched(User user);
}
