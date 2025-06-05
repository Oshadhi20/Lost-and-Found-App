package lk.ijse.cmjd108.Lost_and_Found.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import lk.ijse.cmjd108.Lost_and_Found.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
