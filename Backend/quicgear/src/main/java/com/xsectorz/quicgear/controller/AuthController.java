package com.xsectorz.quicgear.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xsectorz.quicgear.config.UserAuthProvider;
import com.xsectorz.quicgear.dto.CredentialsDto;
import com.xsectorz.quicgear.dto.SignUpDto;
import com.xsectorz.quicgear.dto.UserDto;
import com.xsectorz.quicgear.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class AuthController {

    private final UserAuthProvider userAuthProvider;
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto ) {
        UserDto user = userService.login(credentialsDto);
        user.setToken(userAuthProvider.createToken(user));
        logger.info("user --> " +  credentialsDto.username());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) {

        UserDto user = userService.register(signUpDto);
        user.setToken(userAuthProvider.createToken(user));

        return ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
    }
    
    

}
