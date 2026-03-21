package com.example.thicketmanaging.controllers;


import com.example.thicketmanaging.dataservices.UserDataService;
import com.example.thicketmanaging.entities.User;
import com.example.thicketmanaging.enums.UserRole;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticketmanagers")
public class TicketManagerController {

    private final UserDataService userService;

    public TicketManagerController(UserDataService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllManagers() {
        return userService.getAllManagers(); // filter role = MANAGER
    }

    @GetMapping("/{id}")
    public Optional<User> getManagerById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createManager(@RequestBody User manager) {
        manager.setUserRole(UserRole.TICKET_MANAGER);
        return userService.createUser(manager);
    }

    @PutMapping("/{id}")
    public Optional<User> updateManager(@PathVariable Long id, @RequestBody User manager) {
        manager.setUserRole(UserRole.TICKET_MANAGER);
        return userService.updateUser(id, manager);
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}