package com.marshad.hellospring.controller;

import com.marshad.hellospring.model.User;
import com.marshad.hellospring.repository.UserRepository;
import com.marshad.hellospring.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<String>register(@RequestBody User user){

        if(userRepository.findByUsername((user.getUsername())).isPresent()){
            return ResponseEntity.badRequest().body("User name already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok().body(user.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody User user){
        return userRepository.findByUsername(user.getUsername())
                .filter(u -> passwordEncoder.matches(user.getPassword(),u.getPassword()))
                .map(u -> ResponseEntity.ok(jwtUtil.generateToken(u.getUsername())))
                .orElse(ResponseEntity.status(404).body("Invalid credentials"));
    }

}
