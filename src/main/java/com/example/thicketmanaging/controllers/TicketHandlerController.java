package com.example.thicketmanaging.controllers;


import com.example.thicketmanaging.dataservices.UserDataService;
import com.example.thicketmanaging.entities.User;
import com.example.thicketmanaging.enums.UserRole;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickethandlers")
public class TicketHandlerController {

    private final UserDataService userService;

    public TicketHandlerController(UserDataService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllHandlers() {
        Logger.getLogger("f");
        return userService.getAllHandlers(); // filter role = HANDLER
    }

    @GetMapping("/{id}")
    public Optional<User> getHandlerById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createHandler(@RequestBody User handler) {
        handler.setUserRole(UserRole.TICKET_HANDLER);
        return userService.createUser(handler);
    }

    @PutMapping("/{id}")
    public Optional<User> updateHandler(@PathVariable Long id, @RequestBody User handler) {
        handler.setUserRole(UserRole.TICKET_HANDLER);
        return userService.updateUser(id, handler);
    }

    @DeleteMapping("/{id}")
    public void deleteHandler(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}