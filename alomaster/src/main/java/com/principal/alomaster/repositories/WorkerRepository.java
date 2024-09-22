package com.principal.alomaster.repositories;

import com.principal.alomaster.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}