package ma.atos.agency.services;

import ma.atos.agency.dto.GestionnaireDto;
import ma.atos.agency.exceptions.AgencyNotFoundException;
import ma.atos.agency.web.dto.Request.GestionnaireRequestDto;

import java.util.List;

public interface IGestionnaireService {

    GestionnaireDto newGestionnaire(GestionnaireRequestDto gestionnaireRequestDto) throws Exception;
    GestionnaireDto updateGestnnaire(GestionnaireRequestDto gestionnaireRequestDto, Long registrationNumber) throws AgencyNotFoundException;

    GestionnaireDto findByRegistrationNumber(Long matricule);
    List<GestionnaireDto> findAll();
    void delete(Long matricule);

}
