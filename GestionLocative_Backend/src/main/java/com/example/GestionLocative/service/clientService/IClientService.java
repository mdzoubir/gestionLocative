package com.example.GestionLocative.service.clientService;

import com.example.GestionLocative.model.Client;
import com.example.GestionLocative.repository.ClientRepository;
import com.example.GestionLocative.response.ClientResponse;

import java.util.List;

public interface IClientService {
    ClientResponse addNewClient(Client client);
    void deleteClient(String clientId);
    ClientResponse getClient(String clientId);
    List<ClientResponse> getAllClient();
}

