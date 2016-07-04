package com.nabivach.movieland.service;

import com.nabivach.movieland.dto.Credentials;
import com.nabivach.movieland.entity.User;
import com.nabivach.movieland.entity.UserToken;

public interface UserService {

    User getUserByCredentials(Credentials userCredentials);

}
