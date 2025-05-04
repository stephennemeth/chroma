package com.chroma.backend.controllers;

import com.chroma.backend.entities.request.CreateUserRequest;
import com.chroma.backend.entities.response.CreateUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/account")
public class AccountController {

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(new CreateUserResponse());
    }
}
