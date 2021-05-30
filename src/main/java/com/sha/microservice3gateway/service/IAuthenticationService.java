package com.sha.microservice3gateway.service;

import com.sha.microservice3gateway.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IAuthenticationService {

    String signInAndReturnJWT(User signInRequest);
}
