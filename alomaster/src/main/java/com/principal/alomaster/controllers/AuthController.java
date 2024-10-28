package com.principal.alomaster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.principal.alomaster.enums.Role;
import com.principal.alomaster.models.Client;
import com.principal.alomaster.models.Worker;
import com.principal.alomaster.repositories.UserRepository;
import com.principal.alomaster.services.AuthService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        
        System.out.print("auth: " + auth);
    if (auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser")) {
        return "redirect:/home";
    }

        model.addAttribute("client", new Client());
        return LOGIN_VIEW;
    }

    @GetMapping("/register-worker")
    public String showRegistrationFormWorker(Model model) {

        if (auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser")) {
            return "redirect:/home";
        }
    
        model.addAttribute("worker", new Worker());
        return REGISTER_WORKER_VIEW;
    }

    @GetMapping("/register-guest")
    public String registerGuest() {

        if (auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser")) {
            return "redirect:/home";
        }
    
        return "redirect:/guest";
    }

    @PostMapping("/register-client")
    public String registerClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {
        System.out.println(!client.getPassword().equals(client.getPasswordConfirm()));
        if (!client.getPassword().equals(client.getPasswordConfirm())) {
            bindingResult.rejectValue("passwordConfirm", "error.client", "Las contraseñas no coinciden");
        }
        
        if (bindingResult.hasErrors()) {
           
            System.out.println(bindingResult.getAllErrors());
            return REGISTER_CLIENT_VIEW;
        }
        
        client.setRole(Role.CLIENT);
        authService.registerUser(client);

        return "redirect:/auth/login";
    }
    
    @PostMapping("/register-worker")
    public String registerWorker(@Valid @ModelAttribute("worker") Worker worker, BindingResult bindingResult) {
        // Verificar si la contraseña o la confirmación son nulas o vacías
        if (worker.getPassword() == null || worker.getPassword().isEmpty() ||
            worker.getPasswordConfirm() == null || worker.getPasswordConfirm().isEmpty()) {
            bindingResult.rejectValue("password", "error.worker", "La contraseña y la confirmación son obligatorias");
            return REGISTER_WORKER_VIEW;
        }
        
        // Comparar las contraseñas
        if (!worker.getPassword().equals(worker.getPasswordConfirm())) {
            bindingResult.rejectValue("passwordConfirm", "error.worker", "Las contraseñas no coinciden");
            return REGISTER_WORKER_VIEW;
        }
        
        if (bindingResult.hasErrors()) {
            return REGISTER_WORKER_VIEW;
        }
        
        worker.setRole(Role.WORKER);
        authService.registerUser(worker);
        return "redirect:/auth/login";
    }
}