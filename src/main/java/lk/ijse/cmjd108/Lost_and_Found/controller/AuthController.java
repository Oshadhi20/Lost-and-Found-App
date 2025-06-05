package lk.ijse.cmjd108.Lost_and_Found.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lk.ijse.cmjd108.Lost_and_Found.dto.AuthResponse;
import lk.ijse.cmjd108.Lost_and_Found.dto.SigninRequest;
import lk.ijse.cmjd108.Lost_and_Found.dto.SignupRequest;
import lk.ijse.cmjd108.Lost_and_Found.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.register(signupRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody SigninRequest signinRequest) {
        return ResponseEntity.ok(authService.authenticate(signinRequest));
    }
}