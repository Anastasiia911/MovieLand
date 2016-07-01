package com.nabivach.movieland.dao;

import com.nabivach.movieland.dto.Credentials;
import com.nabivach.movieland.entity.User;


//DAO as light as possible and exists to provide a connection to the DB

public interface UserDao {
    User getUserByCredentials(Credentials userCredentials);

}
