package com.principal.alomaster.controllers;

// * imports

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/client")
    public String clientPage() {
        return "Bienvenido, Client!";
    }
}