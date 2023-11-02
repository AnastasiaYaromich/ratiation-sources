package com.npp.radiationsources.controllers;

import com.npp.radiationsources.dto.JwtRequest;
import com.npp.radiationsources.dto.JwtResponse;
import com.npp.radiationsources.exceptions.AppError;
import com.npp.radiationsources.services.UserService;
import com.npp.radiationsources.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService employeeService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError("CHECK_TOKEN_ERROR",
                    "Incorrect name or password"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = employeeService.loadUserByUsername(authRequest.getName());
        String token = jwtTokenUtil.generateToken(userDetails);
        return  ResponseEntity.ok(new JwtResponse(token));
    }
}
