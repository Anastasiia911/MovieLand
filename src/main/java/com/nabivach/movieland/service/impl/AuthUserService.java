package com.nabivach.movieland.service.impl;


import com.nabivach.movieland.dto.Credentials;
import com.nabivach.movieland.service.UserService;

public class AuthUserService implements UserService {

    @Override
    public String getUserByToken() {
        return null;
    }

    @Override
    public boolean checkUserRegistredInDB(Credentials userCredentials) {
        return false;
    }
}


