package ma.atos.agency.web.controllers;

import ma.atos.agency.dto.ClientDto;
import ma.atos.agency.entities.Client;
import ma.atos.agency.exceptions.ClientNotFoundException;
import ma.atos.agency.services.imp.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/addClient")
    ClientDto createClient(@RequestBody ClientDto newClientDto) {
        Client client = clientService.newClient(newClientDto);
        return new ClientDto(client.getClientId(), client.getName(), client.getAgency());
    }

    @PostMapping("/showClients")
    List<ClientDto> all(){
        return clientService.getAll();
    }

    @PostMapping("/showClient")
    ClientDto one(Long clientId) throws ClientNotFoundException{
        return clientService.getClient(clientId);
    }

    @PostMapping("/updateClient")
    ClientDto updateClient(@RequestBody ClientDto newClientDto, Long clientId) throws ClientNotFoundException {
        Client client = clientService.updateClient(newClientDto, clientId);
        return new ClientDto(client.getClientId(), client.getName(), client.getAgency());
    }

    @PostMapping("/deleteClient")
    void deleteClient(Long clientId) throws ClientNotFoundException {
        clientService.deleteClient(clientId);
    }

}
