package com.nabivach.movieland.service;

import com.nabivach.movieland.dto.UserCredentials;

public interface SecurityService {

    String authUserGenerateToken(UserCredentials userCredentials);
    void checkIsTokenValid();
    void invalidateExpiredTokens();

}
