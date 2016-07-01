package com.nabivach.movieland.service;

import com.nabivach.movieland.dto.Credentials;

public interface SecurityService {

    String authUserGenerateToken(Credentials userCredentials);
    void checkIsTokenValid();
    void invalidateExpiredTokens();

}
