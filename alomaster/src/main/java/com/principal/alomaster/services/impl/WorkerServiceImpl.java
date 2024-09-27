package com.principal.alomaster.services.impl;

import com.principal.alomaster.models.Worker;
import com.principal.alomaster.repositories.WorkerRepository;
import com.principal.alomaster.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker getWorkerById(Long id) {
        return workerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveWorker(Worker worker) {
        workerRepository.save(worker);
    }

    @Override
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}