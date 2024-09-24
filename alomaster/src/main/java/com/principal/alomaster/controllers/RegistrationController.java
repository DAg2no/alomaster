package com.principal.alomaster.controllers;


import com.principal.alomaster.enums.Role;
import com.principal.alomaster.models.Client;
import com.principal.alomaster.models.Worker;
import com.principal.alomaster.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register/client")
    public String showClientRegistrationForm(Model model) {
        model.addAttribute("client", new Client());
        return "register-client";
    }

    @PostMapping("/register/client")
    public String registerClient(@ModelAttribute Client client, Model model) {
        client.setRole(Role.CLIENT);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        userRepository.save(client);
        return "redirect:/auth/register/success";
    }

    @GetMapping("/register/worker")
    public String showWorkerRegistrationForm(Model model) {
        model.addAttribute("worker", new Worker());
        return "register-worker";
    }

    @PostMapping("/register/worker")
    public String registerWorker(@ModelAttribute Worker worker) {
        worker.setRole(Role.WORKER);
        worker.setPassword(passwordEncoder.encode(worker.getPassword()));
        userRepository.save(worker);
        return "redirect:/auth/register/success";
    }

    @GetMapping("/register/success")
    public String registrationSuccess() {
        return "register-success";
    }
}