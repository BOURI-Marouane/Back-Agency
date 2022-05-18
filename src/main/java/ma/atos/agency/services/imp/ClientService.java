package ma.atos.agency.services.imp;

import ma.atos.agency.dto.ClientDto;
import ma.atos.agency.dto.web.ResponseListClientDto;
import ma.atos.agency.entities.Client;
import ma.atos.agency.exceptions.AgencyNotFoundException;
import ma.atos.agency.exceptions.ClientNotFoundException;
import ma.atos.agency.mappers.ClientMapper;

import ma.atos.agency.repositories.ClientRepository;
import ma.atos.agency.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    /**
     * @return
     */
    @Override
    public ResponseEntity getAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDto> clientDtos = clientMapper.MapToListClientDto(clients);
        return new ResponseEntity<>(clientDtos,HttpStatus.OK
        );

    }

    /**
     * @param
     * @return
     */
    @Override
    public ResponseEntity newClient(ClientDto clientDto) throws AgencyNotFoundException {
        Client client = clientMapper.MaptoEntity(clientDto);
        client.setId(0);
        client = clientRepository.save(client);
        clientDto.setId(client.getId());
        return new ResponseEntity<>(clientDto,HttpStatus.OK);

    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity getOneClientById(Long id) throws ClientNotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        if(!client.isPresent())
            throw new ClientNotFoundException();
        ClientDto clientDto = clientMapper.MapToDto(client.get());
        return ResponseEntity.ok().body(clientDto);

    }

    /**
     * @param clientDto
     * @return
     */
    @Override
    public ResponseEntity updateClient(ClientDto clientDto) throws AgencyNotFoundException, ClientNotFoundException {
        Optional<Client> clientOptional = clientRepository.findById(clientDto.getId());
        if(!clientOptional.isPresent())
            throw new ClientNotFoundException();
         Client client = clientMapper.MaptoEntity(clientDto);
         clientRepository.save(client);
        return ResponseEntity.ok().body(client);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity deleteClient(ClientDto clientDto) throws ClientNotFoundException {
        Optional<Client> clientOptional = clientRepository.findById(clientDto.getId());
        if(!clientOptional.isPresent())
            throw new ClientNotFoundException();
        clientOptional.get().setAgency(null);
        clientRepository.save(clientOptional.get());
        return ResponseEntity.ok().body(clientOptional.get());
    }

    /**
     * @return
     */

}
