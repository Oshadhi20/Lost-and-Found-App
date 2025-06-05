package lk.ijse.cmjd108.Lost_and_Found.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Optional: One-to-many with Requests
    @OneToMany(mappedBy = "user")
    private List<Request> requests;
}
