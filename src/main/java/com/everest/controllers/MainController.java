package com.everest.controllers;

import com.everest.entities.User;
import com.everest.serveres.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String homePage() {
        return "home";
    }

    @GetMapping("/only_for_admins")
    public String homePage1() {
        return "home";
    }

    @GetMapping("/read-profile")
    public String homePage2() {
        return "home";
    }

    @GetMapping("/authenticated")
    public String pageForAuthenticated(Principal principal) {
        User user = userService.findByUserName(principal.getName());

        return "secured part of web service" + principal.getName() + " " + user.getEmail();
    }
}
