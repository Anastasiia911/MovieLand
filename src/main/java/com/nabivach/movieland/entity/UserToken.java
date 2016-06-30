package com.nabivach.movieland.entity;

import com.nabivach.movieland.dto.UserCredentials;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserToken {
    private int userId;
    private LocalDateTime generationTime;
    private int token;

    public int getToken() {
        return token;
    }

    public LocalDateTime getGenerationTime() {
        return generationTime;
    }

   public UserToken (int userId) {
       this.userId =userId;
        generationTime = LocalDateTime.now();
        UUID token = UUID.randomUUID();
           }

}
