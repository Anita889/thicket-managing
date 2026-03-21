package com.example.thicketmanaging.controllers;

import com.example.thicketmanaging.dataservices.UserDataService;
import com.example.thicketmanaging.entities.User;
import com.example.thicketmanaging.enums.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final UserDataService userService;

    public AdminController(UserDataService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllAdmins() {
        List<User> admins = userService.getAllManagers(); // Assuming admins are managers
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<User> getAdminById(@PathVariable Long adminId) {
        Optional<User> admin = userService.getUserById(adminId);
        return admin.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createAdmin(@RequestBody User admin) {
        admin.setUserRole(UserRole.TICKET_MANAGER); // Assuming admins have the role TICKET_MANAGER
        User createdAdmin = userService.createUser(admin);
        return ResponseEntity.ok(createdAdmin);
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<User> updateAdmin(@PathVariable Long adminId, @RequestBody User admin) {
        Optional<User> updatedAdmin = userService.updateUser(adminId, admin);
        return updatedAdmin.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long adminId) {
        userService.deleteUser(adminId);
        return ResponseEntity.noContent().build();
    }
}