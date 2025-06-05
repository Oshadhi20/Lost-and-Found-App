package lk.ijse.cmjd108.Lost_and_Found.service;

import org.springframework.stereotype.Service;

import lk.ijse.cmjd108.Lost_and_Found.dto.AuthResponse;
import lk.ijse.cmjd108.Lost_and_Found.dto.SigninRequest;
import lk.ijse.cmjd108.Lost_and_Found.dto.SignupRequest;
import lk.ijse.cmjd108.Lost_and_Found.entity.User;
import lk.ijse.cmjd108.Lost_and_Found.repository.UserRepository;
import lk.ijse.cmjd108.Lost_and_Found.util.JwtUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String register(SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setEmail(signupRequest.getEmail());
        user.setRole(signupRequest.getRole());

        userRepository.save(user);
        return "User registered successfully";
    }

    public AuthResponse authenticate(SigninRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(new UserDetailsImpl(user));
        return new AuthResponse(token, user.getUsername(), user.getRole());
    }
}