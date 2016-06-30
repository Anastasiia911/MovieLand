package com.nabivach.movieland.service.impl;


import com.nabivach.movieland.dto.UserCredentials;
import com.nabivach.movieland.service.UserService;

public class AuthUserService implements UserService {


    @Override
    public String getUserByToken() {
        return null;
    }

    @Override
    public boolean checkUserRegistredInDB(UserCredentials userCredentials) {
        return false;
    }
}


