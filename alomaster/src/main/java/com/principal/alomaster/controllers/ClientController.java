package com.principal.alomaster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.principal.alomaster.models.Client;
import com.principal.alomaster.services.ClientService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/client")
public class ClientController {

    private static final String HOME_VIEW = "client/home";
    private static final String PROFILE_VIEW = "client/perfil";
    private static final String SEARCH_VIEW = "client/search";
    private static final String FORM_VIEW = "client/form";

    @Autowired
    private ClientService clientService;


    @GetMapping(value = ("/home"))
    public String homePage(Model model) {
        return HOME_VIEW;
    }

    @GetMapping("/perfil")
    public String showPerfil(Model model) {
        return PROFILE_VIEW;
    }
    

/*     @GetMapping("/favoritos")
    public String getMethodName(@RequestParam String param) {
        return ;
    }
     */

     @GetMapping("/search")
     public String searchWorker() {
         return SEARCH_VIEW;
     }
     

    @GetMapping("/{id}/edit")
    public String editClient(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "/client/form";
    }

    @GetMapping("/{id}/delete")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/client";
    }
}