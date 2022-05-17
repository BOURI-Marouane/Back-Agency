package ma.atos.agency.mappers;

import ma.atos.agency.dto.ClientDto;
import ma.atos.agency.entities.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public static Client toClient(ClientDto clientDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(clientDto, Client.class);
    }

    public static ClientDto toClientDto(Client client){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(client, ClientDto.class);
    }
}
