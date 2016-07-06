package com.nabivach.movieland.service;

import com.nabivach.movieland.dto.Credentials;
import com.nabivach.movieland.entity.UserToken;
import com.nabivach.movieland.exceptions.AuthorizationException;

public interface SecurityService {

    UserToken userAuthGenerateToken(Credentials credentials) throws AuthorizationException;
   }
