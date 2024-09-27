package com.principal.alomaster.controllers;

import com.principal.alomaster.enums.Role;
import com.principal.alomaster.models.User;
import com.principal.alomaster.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "auth";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "auth";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/auth/success";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        return userRepository.findByUsername(username).map(user -> {
            if (passwordEncoder.matches(password, user.getPassword())) {
                if (user.getRole().equals(Role.WORKER)) {
                    return "redirect:/worker/home";
                } else if (user.getRole().equals(Role.CLIENT)) {
                    return "redirect:/client/home";
                } else {
                    return "redirect:/auth";
                }
            } else {
                model.addAttribute("error", "Incorrect username or password"); // Preferably localize this message
                return "auth";
            }
        }).orElseGet(() -> {
            model.addAttribute("error", "Incorrect username or password"); // Preferably localize this message
            return "auth";
        });
    }

    @GetMapping("/success")
    public String registrationSuccess() {
        return "register-success";
    }
}