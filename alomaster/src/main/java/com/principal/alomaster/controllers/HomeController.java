package com.principal.alomaster.controllers;

import ch.qos.logback.core.model.Model;
import com.principal.alomaster.enums.Role;
import com.principal.alomaster.models.User;
import com.principal.alomaster.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;


public class HomeController {


    private final UserRepository userRepository;

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal User user, Model model) {
        if (user.getRole() == Role.WORKER) {
            return "redirect:/worker/home";
        } else if (user.getRole() == Role.CLIENT) {
            return "redirect:/client/home";
        } else {
            return "redirect:/login";
        }
    }

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}