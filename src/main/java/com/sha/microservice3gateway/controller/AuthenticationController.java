package com.sha.microservice3gateway.controller;

import com.sha.microservice3gateway.model.User;
import com.sha.microservice3gateway.service.IAuthenticationService;
import com.sha.microservice3gateway.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/authentication") //pre-path
public class AuthenticationController
{
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("sign-up") // api/authentication
    public ResponseEntity<?> signUp(@RequestBody User user){
    if (userService.fingByUsername(user.getUsername()).isPresent())
    {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @PostMapping("sign-in") // api/authentication
    public ResponseEntity<?> signIn(@RequestBody User user)
    {
       return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user),HttpStatus.OK);
    }

}
