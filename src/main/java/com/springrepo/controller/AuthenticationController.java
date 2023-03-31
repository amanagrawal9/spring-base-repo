package com.springrepo.controller;

import com.springrepo.dto.ResponseWrapper;
import com.springrepo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseWrapper> generateToken(@RequestBody ContactEntity contact) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(contact.getUserName(), contact.getPassword())
            );
        } catch (Exception ex) {
            return new ResponseEntity<ResponseWrapper>(new ResponseWrapper("Invalid Credentials", null), HttpStatus.UNAUTHORIZED);
        }
        String token = jwtUtil.generateToken(contact.getUserName());
        return new ResponseEntity<ResponseWrapper>(new ResponseWrapper("JWT", token), HttpStatus.OK);
    }
}
