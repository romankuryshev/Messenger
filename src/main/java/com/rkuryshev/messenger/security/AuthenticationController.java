package com.rkuryshev.messenger.security;

import com.rkuryshev.messenger.security.dto.JwtRequest;
import com.rkuryshev.messenger.security.dto.JwtResponse;
import com.rkuryshev.messenger.security.dto.RegistrationRequest;
import com.rkuryshev.messenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/auth")
    public JwtResponse createToken(@RequestBody JwtRequest authenticationRequest) {
        return authenticationService.createToken(authenticationRequest);
    }

    @PostMapping("/registration")
    public void createNewUser(@RequestBody RegistrationRequest registrationRequest) {
        authenticationService.createNewUser(registrationRequest);
    }
}
