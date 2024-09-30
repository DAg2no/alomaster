package com.principal.alomaster.controllers;

import com.principal.alomaster.enums.Role;
import com.principal.alomaster.models.Client;
import com.principal.alomaster.models.User;
import com.principal.alomaster.models.Worker;
import com.principal.alomaster.repositories.UserRepository;
import com.principal.alomaster.services.AuthService;
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

    private static final String LOGIN_VIEW = "auth";
    private static final String REGISTER_WORKER_VIEW = "registerWorker";
    private static final String REGISTER_CLIENT_VIEW = "auth";

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("client", new Client());
        return LOGIN_VIEW;
    }

    @GetMapping("/register-worker")
    public String showRegistrationFormWorker(Model model) {
        model.addAttribute("worker", new Worker());
        return REGISTER_WORKER_VIEW;
    }

    @GetMapping("/register-guest")
    public String registerGuest() {
        return "redirect:/guest";
    }

    @PostMapping("/register-client")
    public String registerClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {
        System.out.println(!client.getPassword().equals(client.getPasswordConfirm()));
        if (!client.getPassword().equals(client.getPasswordConfirm())) {
            bindingResult.rejectValue("passwordConfirm", "error.client", "Las contraseñas no coinciden");
        }
        System.out.println("antes de errores");
        if (bindingResult.hasErrors()) {
            System.out.println("dentro de errores");
            System.out.println(bindingResult.getAllErrors());
            return REGISTER_CLIENT_VIEW;
        }
        System.out.println("antes del register");
        client.setRole(Role.CLIENT);
        authService.registerUser(client);

        return "redirect:/auth/login";
    }

    @PostMapping("/register-worker")
    public String registerWorker(@Valid @ModelAttribute("worker") Worker worker, BindingResult bindingResult) {
        if (!worker.getPassword().equals(worker.getPasswordConfirm())) {
            bindingResult.rejectValue("passwordConfirm", "error.worker", "Las contraseñas no coinciden");
        }
        System.out.println("antes de errores del worker");
        if (bindingResult.hasErrors()) {
            System.out.println("dentro de errores del worker");
            System.out.println(bindingResult.hasErrors());
            return REGISTER_WORKER_VIEW;
        }
        worker.setRole(Role.WORKER);
        authService.registerUser(worker);
        return "redirect:/auth/login";
    }
}