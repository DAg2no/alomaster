package com.principal.alomaster.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerController {

    @GetMapping("/worker")
    public String workerPage() {
        return "Bienvenido, Worker!";
    }
}