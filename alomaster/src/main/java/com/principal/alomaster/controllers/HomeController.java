package com.principal.alomaster.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.principal.alomaster.enums.Role;
import com.principal.alomaster.models.User;
import com.principal.alomaster.repositories.UserRepository;

import ch.qos.logback.core.model.Model;


@Controller
@RequestMapping("/home")
public class HomeController {
    private final UserRepository userRepository;

    @GetMapping
    public String home(Model model, @AuthenticationPrincipal User user) {
        if (user != null) {

            if (user.getRole() == Role.WORKER) {
                System.out.println(user.getRole() == Role.WORKER);
                System.out.println("worker logeado");
                return "redirect:/worker/home";
            } else if (user.getRole() == Role.CLIENT) {
                System.out.println("cliente logeado");
                System.out.println(user.getRole() == Role.CLIENT);
                return "redirect:/client/home";
            }
        }

        return "redirect:/auth/login";
    }

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}