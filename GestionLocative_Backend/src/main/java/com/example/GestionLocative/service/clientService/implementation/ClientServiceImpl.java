package com.example.GestionLocative.service.clientService.implementation;


import com.example.GestionLocative.model.Admin;
import com.example.GestionLocative.model.Client;
import com.example.GestionLocative.repository.ClientRepository;
import com.example.GestionLocative.response.ClientResponse;
import com.example.GestionLocative.service.accountService.IAccountService;
import com.example.GestionLocative.service.clientService.IClientService;
import com.example.GestionLocative.shared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Utils utils;

    @Override
    public ClientResponse addNewClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setUserId(utils.generateUserID(32));
        Client c = clientRepository.save(client);
        accountService.addRoleToUser(client.getEmail(), "CLIENT");
        ClientResponse clientResponse = new ClientResponse();
        BeanUtils.copyProperties(c, clientResponse);
        return clientResponse;
    }

    @Override
    public void deleteClient(String clientId) {
        Optional<Client> client = clientRepository.findByUserId(clientId);
        clientRepository.delete(client.get());
    }

    @Override
    public ClientResponse getClient(String clientId) {
        Optional<Client> client = clientRepository.findByUserId(clientId);
        if (client.isEmpty()) return null;
        ClientResponse clientResponse = new ClientResponse();
        BeanUtils.copyProperties(client.get(), clientResponse);
        return clientResponse;
    }

    @Override
    public List<ClientResponse> getAllClient() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponse> clientResponses =new ArrayList<>();
        for(Client client : clients){
            ClientResponse clientResponse = new ClientResponse();
            BeanUtils.copyProperties(client, clientResponse);
            clientResponses.add(clientResponse);
        }
        return clientResponses;
    }
}
