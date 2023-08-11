package com.rkuryshev.messenger.security;

import com.rkuryshev.messenger.entity.User;
import com.rkuryshev.messenger.exeption.AuthorizationException;
import com.rkuryshev.messenger.exeption.UsernameExistsException;
import com.rkuryshev.messenger.security.dto.JwtRequest;
import com.rkuryshev.messenger.security.dto.JwtResponse;
import com.rkuryshev.messenger.security.dto.RegistrationRequest;
import com.rkuryshev.messenger.security.utils.JwtTokenUtil;
import com.rkuryshev.messenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    public JwtResponse createToken(JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new AuthorizationException("Invalid username or password");
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return new JwtResponse(token);
    }

    public void createNewUser(RegistrationRequest registrationRequest) {
        try {
            userService.createNewUser(registrationRequest);
        } catch (UsernameExistsException e) {
            throw new UsernameExistsException(String.format("User with username '%s' exists", registrationRequest.getUsername()));
        }
    }
}
