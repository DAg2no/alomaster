package com.principal.alomaster.controllers;

import com.principal.alomaster.models.Worker;
import com.principal.alomaster.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @GetMapping
    public String getAllWorkers(Model model) {
        List<Worker> workers = workerService.getAllWorkers();
        model.addAttribute("workers", workers);
        return "worker/list";
    }

    @GetMapping("/new")
    public String newWorker(Model model) {
        model.addAttribute("worker", new Worker());
        return "worker/form";
    }

    @PostMapping
    public String saveWorker(@ModelAttribute Worker worker) {
        workerService.saveWorker(worker);
        return "redirect:/worker";
    }

    @GetMapping("/{id}")
    public String getWorkerById(@PathVariable Long id, Model model) {
        Worker worker = workerService.getWorkerById(id);
        model.addAttribute("worker", worker);
        return "worker/detail";
    }

    @GetMapping("/{id}/edit")
    public String editWorker(@PathVariable Long id, Model model) {
        Worker worker = workerService.getWorkerById(id);
        model.addAttribute("worker", worker);
        return "worker/form";
    }

    @GetMapping("/{id}/delete")
    public String deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return "redirect:/worker";
    }
}