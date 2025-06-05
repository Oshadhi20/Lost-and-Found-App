package lk.ijse.cmjd108.Lost_and_Found.dto;

import lk.ijse.cmjd108.Lost_and_Found.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String username;
    private Role role;
}