package com.nabivach.movieland.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserToken {

    private final User user;
    private LocalDateTime generationTime;
    private LocalDateTime expirationTime = generationTime.plusHours(2);
    private String token;

    public String getToken() {
        return token;
    }

    public LocalDateTime getGenerationTime() {
        return generationTime;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public UserToken(User user) {
        this.user = user;
        generationTime = LocalDateTime.now();
        String token = UUID.randomUUID().toString();
    }

}
