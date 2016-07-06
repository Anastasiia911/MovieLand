package com.nabivach.movieland.service.impl;
import com.nabivach.movieland.dao.UserDao;
import com.nabivach.movieland.dto.Credentials;
import com.nabivach.movieland.entity.User;
import com.nabivach.movieland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericUserService implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User getUserByCredentials(Credentials credentials) {
        User user = userDao.getUserByCredentials(credentials);
        return user;
    }
}



