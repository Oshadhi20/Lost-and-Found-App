package lk.ijse.cmjd108.Lost_and_Found.dto;

import lk.ijse.cmjd108.Lost_and_Found.entity.Role;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Role role;
}
