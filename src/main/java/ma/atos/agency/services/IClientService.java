package ma.atos.agency.services;

import ma.atos.agency.dto.ClientDto;
import ma.atos.agency.exceptions.AgencyNotFoundException;
import ma.atos.agency.exceptions.ClientNotFoundException;
import org.springframework.http.ResponseEntity;

public interface IClientService {

    ResponseEntity getAll ();
    ResponseEntity newClient (ClientDto clientDto) throws AgencyNotFoundException;
    ResponseEntity getOneClientById (Long id) throws ClientNotFoundException;

    ResponseEntity<?> updateClient (ClientDto requestClientDto) throws AgencyNotFoundException, ClientNotFoundException;

    ResponseEntity<?> deleteClient(ClientDto clientDto) throws ClientNotFoundException;


}
