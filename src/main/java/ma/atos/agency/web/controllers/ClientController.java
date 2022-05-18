package ma.atos.agency.web.controllers;

import ma.atos.agency.dto.ClientDto;
import ma.atos.agency.dto.web.ResponseClientDto;
import ma.atos.agency.dto.web.ResponseListClientDto;
import ma.atos.agency.entities.Client;
import ma.atos.agency.exceptions.ClientNotFoundException;
import ma.atos.agency.mappers.ClientMapper;
import ma.atos.agency.services.imp.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/all")
    ResponseEntity all() {
        try {
            return clientService.getAll();
        } catch (Exception exception){
            return new ResponseEntity<>("erreur",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/create")
    ResponseEntity createClient(@RequestBody ClientDto clientDto) {
        try {
            return clientService.newClient(clientDto);
        } catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/get")
    ResponseEntity getCLient(@RequestBody ClientDto clientDto) throws ClientNotFoundException {
        try {
            return clientService.getOneClientById(clientDto.getId());
        } catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/update")
    ResponseEntity updateClient(@RequestBody ClientDto clientDto){
        try {
            return clientService.updateClient(clientDto);
        } catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @PostMapping("/delete")
    ResponseEntity deleteClient(@RequestBody ClientDto clientDto){
        try {
            return clientService.deleteClient(clientDto);
        } catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
