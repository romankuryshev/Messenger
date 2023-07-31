package com.rkuryshev.messenger.security;

import com.rkuryshev.messenger.security.dto.JwtRequest;
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
    public ResponseEntity<?> createToken(@RequestBody JwtRequest authenticationRequest) {
        return authenticationService.createToken(authenticationRequest);
    }
}
