package ma.atos.agency.services;

import ma.atos.agency.dto.GestionnaireDto;

import java.util.List;

public interface IGestionnaireService {

    GestionnaireDto newGestionnaire(GestionnaireDto gestionnaireDto);
    GestionnaireDto updateGestnnaire(GestionnaireDto gestionnaireDto);

    GestionnaireDto findByRegistrationNumber(Long matricule);
    List<GestionnaireDto> findAll();
    void delete(Long matricule);

}
