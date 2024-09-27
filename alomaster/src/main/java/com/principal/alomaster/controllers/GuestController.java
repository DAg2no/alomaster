package com.principal.alomaster.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GuestController {

    @GetMapping("/guest")
    public String guestPage() {
        return "Bienvenido, Invitado!";
    }
}