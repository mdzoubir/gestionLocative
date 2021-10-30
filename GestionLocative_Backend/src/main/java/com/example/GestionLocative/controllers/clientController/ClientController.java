package com.example.GestionLocative.controllers.clientController;

import com.example.GestionLocative.model.Client;
import com.example.GestionLocative.response.ClientResponse;
import com.example.GestionLocative.service.clientService.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/client")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @GetMapping
    private List<ClientResponse> getAllClient(){
        return clientService.getAllClient();
    }

    //test done
    @PostMapping()
    private ClientResponse addNewClient(@RequestBody Client client){
        return clientService.addNewClient(client);
    }

    @DeleteMapping(path = "/{clientId}")
    private void deleteClient(@PathVariable String clientId){
        clientService.deleteClient(clientId);
    }

    //test done
    @GetMapping(path = "/{clientId}")
    private ClientResponse getClient(@PathVariable String clientId){
        return clientService.getClient(clientId);
    }
}
