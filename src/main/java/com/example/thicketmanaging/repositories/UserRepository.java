package com.example.thicketmanaging.repositories;

import com.example.thicketmanaging.entities.User;
import com.example.thicketmanaging.enums.UserRole;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE user_role = :userRole")
    List<User> findByRole(UserRole userRole);
}
