package com.nabivach.movieland.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nabivach.movieland.service.impl.CachedSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserToken {
    @JsonIgnore
    private User user;
    @JsonIgnore
    private LocalDateTime expirationTime;

    private String token;

    @Autowired
    CachedSecurityService cachedSecurityService;

    public UserToken(User user) {
        this.user = user;
        expirationTime = LocalDateTime.now().plusHours(2);
        token = UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public User getUser() {
        return user;
    }


}
