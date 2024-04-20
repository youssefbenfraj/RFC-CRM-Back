package pfe.rfc.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.dto.SignupRequest;
import pfe.rfc.crm.interfaces.IAuthService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin()

@RestController
@RequestMapping("/signup")
public class SignupController {


    private final IAuthService authService ;
    @Autowired
    public SignupController(IAuthService authService) {

        this.authService = authService;
    }
    @PostMapping
    public ResponseEntity<String> signupUser(@RequestBody SignupRequest signupRequest) throws IOException {
        boolean isUserCreated = authService.createUser(signupRequest);
        if (isUserCreated) {

            return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"User created successfully\"}");
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Failed to create user\"}");
        }

    }




}


