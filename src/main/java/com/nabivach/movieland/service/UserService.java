package com.nabivach.movieland.service;

import com.nabivach.movieland.dto.Credentials;

public interface UserService {

 String getUserByToken();
    //check from cache User -using token

 boolean checkUserRegistredInDB(Credentials userCredentials);
    // check mail and pass in DB equal to given in auth window

}
