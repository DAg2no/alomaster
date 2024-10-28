package com.principal.alomaster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.principal.alomaster.models.Worker;
import com.principal.alomaster.services.WorkerService;



@Controller
@RequestMapping("/worker/home")
public class WorkerController {

    private static final String HOME_VIEW = "worker/home";
    private static final String FORM_VIEW = "worker/form";


    @Autowired
    private WorkerService workerService;


    @GetMapping
    public String homePage(Model model) {
        return HOME_VIEW;
    }


    @GetMapping("/{id}/edit")
    public String editWorker(@PathVariable Long id, Model model) {
        Worker worker = workerService.getWorkerById(id);
        model.addAttribute("worker", worker);
        return FORM_VIEW;
    }

    @GetMapping("/{id}/delete")
    public String deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return "redirect:/worker";
    }
}