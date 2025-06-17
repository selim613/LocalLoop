package com.example.localloop.loginactivities;

import com.example.localloop.entities.User;

public interface Helper {
    void onUserFetched(User user);
    void onError(String errorMessage);
}

