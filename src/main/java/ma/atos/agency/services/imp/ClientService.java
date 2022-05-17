package ma.atos.agency.services.imp;

import ma.atos.agency.dto.ClientDto;
import ma.atos.agency.dto.GestionnaireDto;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.entities.Client;
import ma.atos.agency.entities.Gestionnaire;
import ma.atos.agency.exceptions.ClientNotFoundException;
import ma.atos.agency.mappers.ClientMapper;
import ma.atos.agency.mappers.GestionnaireConverter;
import ma.atos.agency.repositories.AgencyRepository;
import ma.atos.agency.repositories.ClientRepository;
import ma.atos.agency.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public Client newClient(ClientDto clientDto){
        Client client = new Client();
        return clientRepository.save(client);
    }

    @Override
    public ClientDto getClient(Long clientId) throws ClientNotFoundException {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
        return ClientMapper.toClientDto(client);
    }

    @Override
    public List<ClientDto> getAll(){
        List<ClientDto> listClientDto = new ArrayList<>();
        List<Client> listClient = clientRepository.findAll();
        listClient.forEach(item -> {
            ClientDto dtoItem = ClientMapper.toClientDto(item);
            listClientDto.add(dtoItem);
        });
        return listClientDto;
    }

    @Override
    public void deleteClient(Long clientId) throws ClientNotFoundException{
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
        for(Client c : client.getAgency().getClientList()){
            c.getAgency().getClientList().remove(client);
            agencyRepository.save(c.getAgency());
        }
        clientRepository.save(client);
        clientRepository.deleteById(clientId);
    }

    @Override
    public ClientDto updateClient(ClientDto newClient, Long clientId) throws ClientNotFoundException{
        Client oldClient = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
        Client clientToUpdate = ClientMapper.toClient(newClient);
        oldClient.setClientId(clientToUpdate.getClientId());
        oldClient.setName(clientToUpdate.getName());
        oldClient.setAgency(clientToUpdate.getAgency());
        return ClientMapper.toClientDto(clientRepository.save(oldClient));
    }
}
