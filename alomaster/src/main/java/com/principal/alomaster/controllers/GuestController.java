package com.principal.alomaster.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GuestController {

    @GetMapping("/guest")
    public String guestPage() {
        return "Bienvenido, Invitado!";
    }
}