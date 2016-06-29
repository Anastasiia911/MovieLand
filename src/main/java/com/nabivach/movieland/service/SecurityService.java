package com.nabivach.movieland.service;

import com.nabivach.movieland.dto.AuthRequestDto;

public interface SecurityService {

    String authUserGenerateToken(AuthRequestDto authRequestDto);
    void checkIsTokenValid();
    void invalidateExpiredTokens();

}
