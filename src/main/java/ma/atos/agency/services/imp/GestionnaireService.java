package ma.atos.agency.services.imp;

import ma.atos.agency.dto.GestionnaireDto;
import ma.atos.agency.entities.Gestionnaire;
import ma.atos.agency.mappers.GestionnaireConverter;
import ma.atos.agency.repositories.GestionnaireRepository;
import ma.atos.agency.services.IGestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireService implements IGestionnaireService {

    @Autowired
    GestionnaireRepository gestionnaireRepository;
    @Override
    public GestionnaireDto newGestionnaire(GestionnaireDto gestionnaireDto) {
        Gestionnaire gestionnaire = GestionnaireConverter.toGestionnaire(gestionnaireDto);
        GestionnaireDto NewgestionnaireDto = GestionnaireConverter.toGestionnaireDto(gestionnaire);
        return NewgestionnaireDto;
    }

    @Override
    public GestionnaireDto updateGestnnaire(GestionnaireDto gestionnaireDto) {

        Gestionnaire gestionnaire = GestionnaireConverter.toGestionnaire(gestionnaireDto);
        Gestionnaire newGestionnaire = gestionnaireRepository.findByRegistrationNumber(gestionnaire.getRegistrationNumber());
        if(newGestionnaire != null)
        {
            newGestionnaire.setRegistrationNumber(gestionnaire.getRegistrationNumber());
            newGestionnaire.setFullName(gestionnaire.getFullName());
            newGestionnaire.setLevel(gestionnaire.getLevel());
            newGestionnaire.setAgency(gestionnaire.getAgency());
            GestionnaireDto newgestionnaireDto = GestionnaireConverter.toGestionnaireDto(gestionnaireRepository.save(newGestionnaire));
            return newgestionnaireDto;
        }
        else
            return null;
    }

    @Override
    public GestionnaireDto findByRegistrationNumber(Long matricule) {
        Gestionnaire gestionnaire = gestionnaireRepository.findByRegistrationNumber(matricule);
        GestionnaireDto gestionnaireDto = new GestionnaireDto();
        gestionnaireDto=GestionnaireConverter.toGestionnaireDto(gestionnaire);
        if(gestionnaire!=null)
            return gestionnaireDto;
        else
            return null;

    }


    @Override
    public List<GestionnaireDto> findAll() {
        List<Gestionnaire> listGestionnaire= new ArrayList<>();
        List<GestionnaireDto> listGestionnaireDto = new ArrayList<>();
        listGestionnaire = gestionnaireRepository.findAll();
        for(Gestionnaire gestionnaire : listGestionnaire)
        {
            listGestionnaireDto.add(GestionnaireConverter.toGestionnaireDto(gestionnaire));
        }
        return listGestionnaireDto;
    }

    @Override
    public void delete(Long matricule) {

        Gestionnaire gestionnaire = gestionnaireRepository.findByRegistrationNumber(matricule);
        gestionnaireRepository.delete(gestionnaire);

    }
}
