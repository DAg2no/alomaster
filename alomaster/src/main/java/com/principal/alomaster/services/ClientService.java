package com.principal.alomaster.services;

import com.principal.alomaster.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ClientService {
    List<Client> getAllClients();

    Client getClientById(Long id);

    void saveClient(Client client);

    void deleteClient(Long id);
}