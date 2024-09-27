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
@RequestMapping("/auth/register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    // FIXME: Inject PasswordEncoder
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/client")
    public String showClientRegistrationForm(Model model) {
        model.addAttribute("client", new Client());
        return "register-client";
    }

    @PostMapping("/client")
    public String registerClient(@ModelAttribute Client client, Model model) {
        client.setRole(Role.CLIENT);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        userRepository.save(client);
        return "redirect:/auth/register/success";
    }

    @GetMapping("/worker")
    public String showWorkerRegistrationForm(Model model) {
        model.addAttribute("worker", new Worker());
        return "register-worker";
    }

    @PostMapping("/worker")
    public String registerWorker(@ModelAttribute Worker worker, Model model) {
        worker.setRole(Role.WORKER);
        worker.setPassword(passwordEncoder.encode(worker.getPassword()));
        userRepository.save(worker);
        return "redirect:/auth/register/success";
    }

    @GetMapping("/success")
    public String registrationSuccess() {
        return "register-success";
    }
}