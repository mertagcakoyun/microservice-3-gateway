package com.sha.microservice3gateway.security;

import com.sha.microservice3gateway.model.User;
import com.sha.microservice3gateway.security.UserPrincipal;
import com.sha.microservice3gateway.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.fingByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found with username:"+username));
        return new UserPrincipal(user.getId(),user.getUsername(),user.getPassword());
    }
}
