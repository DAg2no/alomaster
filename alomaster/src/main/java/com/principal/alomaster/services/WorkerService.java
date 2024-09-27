package com.principal.alomaster.services;

import com.principal.alomaster.models.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkerService {
    List<Worker> getAllWorkers();

    Worker getWorkerById(Long id);

    void saveWorker(Worker worker);

    void deleteWorker(Long id);
}