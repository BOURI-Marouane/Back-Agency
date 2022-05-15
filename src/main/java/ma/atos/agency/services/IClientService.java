package ma.atos.agency.services;

import ma.atos.agency.dto.ClientDto;
import ma.atos.agency.entities.Client;
import ma.atos.agency.exceptions.ClientNotFoundException;

import java.util.List;

public interface IClientService {

    Client newClient(ClientDto clientDto);

    ClientDto getClient(Long clientId) throws ClientNotFoundException;

    void deleteClient(Long clientId) throws ClientNotFoundException;

    Client updateClient(ClientDto newClient, Long clientId) throws ClientNotFoundException;

    List<ClientDto> getAll();

}
