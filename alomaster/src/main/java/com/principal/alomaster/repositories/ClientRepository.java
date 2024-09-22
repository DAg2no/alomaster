package com.principal.alomaster.repositories;

import com.principal.alomaster.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}