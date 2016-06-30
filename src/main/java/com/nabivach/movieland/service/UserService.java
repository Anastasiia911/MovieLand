package com.nabivach.movieland.service;

import com.nabivach.movieland.dto.UserCredentials;

public interface UserService {

 String getUserByToken();
 boolean checkUserRegistredInDB(UserCredentials userCredentials);

}
