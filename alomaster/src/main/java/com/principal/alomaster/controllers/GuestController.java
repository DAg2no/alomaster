package com.principal.alomaster.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {

    @GetMapping("/guest")
    public String guestPage() {
        return "Bienvenido, Invitado!";
    }
}