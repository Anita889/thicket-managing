package com.example.thicketmanaging.controllers;

import com.example.thicketmanaging.dataservices.UserDataService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final UserDataService userService;

    public AdminController(UserDataService userService) {
        this.userService = userService;
    }

}