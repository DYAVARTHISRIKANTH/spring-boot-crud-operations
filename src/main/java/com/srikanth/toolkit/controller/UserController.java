package com.srikanth.toolkit.controller;

import com.srikanth.toolkit.dto.LoginRequest;
import com.srikanth.toolkit.dto.RegisterRequest;
import com.srikanth.toolkit.dto.UpdateUserRequest;
import com.srikanth.toolkit.model.User;
import com.srikanth.toolkit.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UserController {
    final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public ResponseEntity<?> findAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> getUser(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest.getUsername(),loginRequest.getPassword());
    }
    @PostMapping("/register")
    public ResponseEntity<?> register( @Valid  @RequestBody RegisterRequest request) {
        return userService.register(request);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return userService.getAllUsers();
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UpdateUserRequest request) {

        return userService.updateUser(id, request);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
