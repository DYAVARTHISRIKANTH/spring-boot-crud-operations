package com.srikanth.toolkit.service;

import com.srikanth.toolkit.repository.UserRepository;
import com.srikanth.toolkit.dto.RegisterRequest;
import com.srikanth.toolkit.dto.UpdateUserRequest;
import com.srikanth.toolkit.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> login(String username, String password) {
        User user=userRepository.findByUsername(username);
        if(user==null){
            return new ResponseEntity<>("Invalid username or password",
                    HttpStatus.UNAUTHORIZED);

        }
        if(user.getPassword().equals(password)){
            return new ResponseEntity<>("Login Successful",HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid username or password",HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<?> register(RegisterRequest request) {
        User user1=new User();
        user1.setEmail(request.getEmail());
        user1.setUsername(request.getUsername());
        user1.setPassword(request.getPassword());
        return new ResponseEntity<>(userRepository.save(user1), HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> updateUser(Long id, UpdateUserRequest request) {

        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isEmpty()) {
            return new ResponseEntity<>("Id Not Found", HttpStatus.NOT_FOUND);
        }

        User user1 = existingUser.get();

        user1.setEmail(request.getEmail());
        user1.setUsername(request.getUsername());
        user1.setPassword(request.getPassword());

        userRepository.save(user1);

        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteUser(Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("Deleted User Successfully",HttpStatus.OK);
    }
}
