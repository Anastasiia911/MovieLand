package com.nabivach.movieland.controller;

import com.nabivach.movieland.dto.Credentials;
import com.nabivach.movieland.entity.UserToken;
import com.nabivach.movieland.exceptions.AuthorizationException;
import com.nabivach.movieland.service.impl.CachedSecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(name = "/v1")
@Controller
public class SecurityController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);
    @Autowired
    CachedSecurityService cachedSecurityService;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity authUser(@RequestParam String login, @RequestParam String password) {
        LOGGER.debug("Starting user auth process..");
        final Credentials credentials = new Credentials();
        credentials.setMail(login);
        credentials.setPassword(password);
        UserToken token = null;
        try {
            token = cachedSecurityService.userAuthGenerateToken(credentials);

        } catch (AuthorizationException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LOGGER.debug("Finishing user auth process..");
        return new ResponseEntity<>(token, HttpStatus.OK);


    }
}
