package ma.atos.agency.mappers;

import ma.atos.agency.dto.ClientDto;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.entities.Client;
import ma.atos.agency.exceptions.AgencyNotFoundException;
import ma.atos.agency.repositories.AgencyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientMapper {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    AgencyRepository agencyRepository;

    public List<ClientDto> MapToListClientDto(List<Client> clients){
        List<ClientDto> clientDtos = new ArrayList<>();
        clients.stream().forEach( item ->{
            clientDtos.add(this.MapToDto(item));
        });
        return clientDtos;
    }

    public Client MaptoEntity(ClientDto requestClientDto) throws AgencyNotFoundException {
        Client client = new Client();
        Optional<Agency> agency;
        client.setId(requestClientDto.getId());
        client.setName(requestClientDto.getName());
        if(requestClientDto.getAgency_name() != null) {
            agency = agencyRepository.findByName(requestClientDto.getAgency_name());
            if(agency.isPresent())
                client.setAgency(agency.get());
            else
                throw new AgencyNotFoundException();
        }
        return client;
    }

    public ClientDto MapToDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        if(client.getAgency()!=null)
            clientDto.setAgency_name(client.getAgency().getName());
        return clientDto;



    }
}
