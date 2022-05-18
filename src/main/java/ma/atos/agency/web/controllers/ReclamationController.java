package ma.atos.agency.web.controllers;


import ma.atos.agency.dto.ClientDto;
import ma.atos.agency.dto.web.ReclamationDto;
import ma.atos.agency.services.imp.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController

public class ReclamationController {
    @Autowired
    ReclamationService reclamationService;

    @PostMapping("/reclamation")
    ResponseEntity getClientReclamation(@RequestBody ClientDto clientDto){
        try {
            return reclamationService.getClientReclamation(clientDto.getClientId());
        } catch (URISyntaxException e) {
            return new ResponseEntity<>("Echec", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
