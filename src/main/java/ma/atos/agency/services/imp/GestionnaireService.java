package ma.atos.agency.services.imp;

import ma.atos.agency.dto.GestionnaireDto;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.entities.Gestionnaire;
import ma.atos.agency.exceptions.AgencyNotFoundException;
import ma.atos.agency.mappers.GestionnaireConverter;
import ma.atos.agency.mappers.repositories.AgencyRepository;
import ma.atos.agency.mappers.repositories.GestionnaireRepository;
import ma.atos.agency.services.IGestionnaireService;
import ma.atos.agency.web.dto.Request.GestionnaireRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GestionnaireService implements IGestionnaireService {

    @Autowired
    GestionnaireRepository gestionnaireRepository;
    @Autowired
    AgencyRepository agencyRepository;

    @Autowired
    GestionnaireConverter gestionnaireConverter;
    @Override
    public GestionnaireDto newGestionnaire(GestionnaireRequestDto gestionnaireRequestDto) throws Exception {

        GestionnaireDto gestionnaireDtoNew = gestionnaireConverter.ResquestToGestionnaireDto(gestionnaireRequestDto);
        Gestionnaire gestionnaireNew = gestionnaireConverter.toGestionnaire(gestionnaireDtoNew);
        Optional<Agency> agency = agencyRepository.findById(gestionnaireRequestDto.getAgency_id());
        if(!agency.isPresent())
            throw new Exception();
        gestionnaireNew.setAgency_id(agency.get());
        Gestionnaire gestionnaire= gestionnaireRepository.save(gestionnaireNew);

        return gestionnaireDtoNew;
    }

    @Override
    public GestionnaireDto updateGestnnaire(GestionnaireRequestDto gestionnaireRequestDto, Long registrationNumber)throws AgencyNotFoundException {
        GestionnaireDto gestionnaireDto = gestionnaireConverter.ResquestToGestionnaireDto(gestionnaireRequestDto);
        Gestionnaire gestionnaire = gestionnaireConverter.toGestionnaire(gestionnaireDto);
        Optional<Gestionnaire> newGestionnaire = gestionnaireRepository.findById(registrationNumber);
        Optional<Agency> agency = agencyRepository.findById(gestionnaireRequestDto.getAgency_id());
        if(newGestionnaire.isPresent() && agency.isPresent())
        {
            newGestionnaire.get().setRegistration_number(gestionnaire.getRegistration_number());
            newGestionnaire.get().setFullName(gestionnaire.getFullName());
            newGestionnaire.get().setLevel(gestionnaire.getLevel());
            newGestionnaire.get().setAgency_id(agency.get());
            GestionnaireDto newgestionnaireDto = gestionnaireConverter.toGestionnaireDto(gestionnaireRepository.save(newGestionnaire.get()));
            return newgestionnaireDto;
        }
        else
            throw new AgencyNotFoundException(registrationNumber);
    }

    @Override
    public GestionnaireDto findByRegistrationNumber(Long matricule) {
        Optional<Gestionnaire> gestionnaire = gestionnaireRepository.findById(matricule);
        GestionnaireDto gestionnaireDto = new GestionnaireDto();
        gestionnaireDto=gestionnaireConverter.toGestionnaireDto(gestionnaire.get());
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
            listGestionnaireDto.add(gestionnaireConverter.toGestionnaireDto(gestionnaire));
        }
        return listGestionnaireDto;
    }

    @Override
    public void delete(Long matricule) {

        Optional<Gestionnaire> gestionnaire = gestionnaireRepository.findById(matricule);
        gestionnaireRepository.delete(gestionnaire.get());

    }
}
