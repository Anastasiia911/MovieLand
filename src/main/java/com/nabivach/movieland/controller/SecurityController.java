package com.nabivach.movieland.controller;

import com.nabivach.movieland.dto.UserCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(name = "/v1")
@Controller
public class SecurityController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void authUser(@RequestParam String login, @RequestParam String password) {
        LOGGER.debug("Starting user authentification process..");
       final UserCredentials userCredentials = new UserCredentials();
       // userCredentials.setLogin(login);
       // userCredentials.setPassword(password);


        LOGGER.debug("Finishing user authentification process..");

    }
}
