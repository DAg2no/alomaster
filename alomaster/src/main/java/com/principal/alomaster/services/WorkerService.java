package com.principal.alomaster.services;

import com.principal.alomaster.models.Worker;
import com.principal.alomaster.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository maestroRepository;

    public Worker crearMaestro(Worker maestro) {
        return maestroRepository.save(maestro);
    }

    // Métodos GET, PUT, DELETE
}