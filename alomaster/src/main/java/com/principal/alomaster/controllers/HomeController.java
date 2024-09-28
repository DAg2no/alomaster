package com.principal.alomaster.controllers;

import ch.qos.logback.core.model.Model;
import com.principal.alomaster.enums.Role;
import com.principal.alomaster.models.User;
import com.principal.alomaster.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final UserRepository userRepository;

    @GetMapping
    public String home(@AuthenticationPrincipal User user, Model model) {
        if (user.getRole() == Role.WORKER) {
            return "redirect:/worker/home";
        } else if (user.getRole() == Role.CLIENT) {
            return "redirect:/client/home";
        } else {
            System.out.println("hola");
            return "redirect:/auth/login";
        }
    }

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}