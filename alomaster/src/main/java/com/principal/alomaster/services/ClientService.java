package com.principal.alomaster.services;

import com.principal.alomaster.models.Client;
import com.principal.alomaster.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clienteRepository;

    public Client crearCliente(Client cliente) {
        return clienteRepository.save(cliente);
    }

    // Métodos GET, PUT, DELETE
}