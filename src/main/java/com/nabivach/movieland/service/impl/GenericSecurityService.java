package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dto.AuthRequestDto;
import com.nabivach.movieland.service.SecurityService;

public class GenericSecurityService implements SecurityService {


    @Override
    public String authUserGenerateToken(AuthRequestDto authRequestDto) {
        return null;
    }

    @Override
    public void checkIsTokenValid() {

    }

    @Override
    public void invalidateExpiredTokens() {

    }
}
