package com.nabivach.movieland.dao;
import com.nabivach.movieland.dto.Credentials;
import com.nabivach.movieland.entity.User;

public interface UserDao {
    User getUserByCredentials(Credentials userCredentials);

}

