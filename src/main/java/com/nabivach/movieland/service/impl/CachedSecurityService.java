package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dto.Credentials;
import com.nabivach.movieland.entity.User;
import com.nabivach.movieland.entity.UserToken;
import com.nabivach.movieland.service.SecurityService;
import com.nabivach.movieland.exceptions.AuthorizationException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CachedSecurityService implements SecurityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CachedSecurityService.class);
    private List<UserToken> tokenCache = new CopyOnWriteArrayList<>();

    @Autowired
    GenericUserService userService;


    @Override
    public UserToken userAuthGenerateToken(Credentials credentials) throws AuthorizationException {
        //login user,generate token/add token to cache
        validateCredentials(credentials);
        User user = userService.getUserByCredentials(credentials);
        validateUser(user);
        UserToken userToken = new UserToken(user);
        tokenCache.add(userToken);
        return userToken;
    }

    private boolean isTokenExpired(UserToken userToken) {
        return LocalDateTime.now().isAfter(userToken.getExpirationTime());
    }

    //validateCredentials
    private void validateCredentials(Credentials credentials) throws AuthorizationException {
        if (credentials.getMail() == null || credentials.getPassword() == null) {
            LOGGER.warn("Empty login or password..");
            throw new AuthorizationException("Error empty login/password");
        }
    }

    private void validateUser(User user) throws AuthorizationException {
        if (user == null) {
            LOGGER.warn("No such user in DB");
            throw new AuthorizationException("No such user in DB/Incorrect login");}

    }

  public int getUserIdByToken(String token){

      for (UserToken userToken : tokenCache) {
          if (userToken.getToken()==token){
             int userId =  userToken.getUser().getUserId();
              return userId;
          }
      }
      return 0;
  }

    private UserToken validateToken(UserToken userToken) {
        return userToken;
    }

    @Scheduled(initialDelay = 2 * 60 * 60 * 1000, fixedRate = 30 * 60 * 1000) //Every 30 mins
    public void invalidateCache() {
        LOGGER.debug("Start checking if tokens are expired and deleting expired tokens");
        for (UserToken userToken : tokenCache) {
            if (isTokenExpired(userToken)) {
                tokenCache.remove(userToken);

            }
        }
        LOGGER.debug("Stop deleting expired tokens");
    }
}
