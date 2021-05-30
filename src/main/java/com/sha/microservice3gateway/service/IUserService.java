package com.sha.microservice3gateway.service;

import com.sha.microservice3gateway.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {
    User saveUser(User user);

    Optional<User> fingByUsername(String username);

    List<User> findAllUsers();
}
