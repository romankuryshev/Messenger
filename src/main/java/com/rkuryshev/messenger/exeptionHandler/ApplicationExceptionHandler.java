package com.rkuryshev.messenger.exeptionHandler;

import com.rkuryshev.messenger.exeption.AuthorizationException;
import com.rkuryshev.messenger.exeption.UsernameExistsException;
import com.rkuryshev.messenger.security.dto.SecureError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler({UsernameExistsException.class, AuthorizationException.class})
    public ResponseEntity<SecureError> handleUsernameExistsException(RuntimeException e) {
        return new ResponseEntity<>(new SecureError(HttpStatus.UNAUTHORIZED.value(), e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
