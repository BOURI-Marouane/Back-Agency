package ma.atos.agency.services.imp;

import ma.atos.agency.dto.AgencyDto;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.entities.Gestionnaire;
import ma.atos.agency.exceptions.AgencyNotFoundException;
import ma.atos.agency.mappers.AgencyConverter;
import ma.atos.agency.repositories.AgencyRepository;
import ma.atos.agency.services.IAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgencyService implements IAgencyService {
    @Autowired
    AgencyRepository agencyRepository;


    @Autowired
    AgencyConverter agencyConverter;



    @Override
    public AgencyDto newAgency(AgencyDto agencyDto) {
        AgencyDto agencyDtoNew = new AgencyDto();

        //agencyDtoNew.setEnabled(true);

        agencyDtoNew.setEnabled(true);

        Agency agency= agencyRepository.save(agencyConverter.toAgency(agencyDto));
        agencyDtoNew=agencyConverter.toAgencyDto(agency);
        return agencyDtoNew;
    }

    // first param (agency_A) pour fussione en en deuxieme parametre
    @Override
    public AgencyDto fussione(Long agency_A, Long agency_B) {

        Optional<Agency> agencyA = agencyRepository.findById(agency_A);
        Optional<Agency> agencyB = agencyRepository.findById(agency_B);
        if(agencyA.isPresent() && agencyB.isPresent()){
            agencyA.get().setEnabled(false);
            agencyA.get().getGestionnaires().stream().forEach(item ->{
                agencyB.get().getGestionnaires().add(item);
            });
            agencyA.get().getGestionnaires().clear();
            agencyRepository.save(agencyA.get());
            agencyRepository.save(agencyB.get());
        }

        return null;

    }

    @Override
    public AgencyDto update(AgencyDto agencyDto) throws AgencyNotFoundException {

        Agency agency = agencyConverter.toAgency(agencyDto);
        Optional<Agency> oAgency = agencyRepository.findById(agency.getCode());
        if(!oAgency.isPresent())
            throw new AgencyNotFoundException();
        Agency newAgency = oAgency.get();

            newAgency.setName(agency.getName());
            newAgency.setCode(agency.getCode());
            newAgency.setGestionnaires(agency.getGestionnaires());
            newAgency.setAdress(agency.getAdress());
            AgencyDto newAgencyDto = agencyConverter.toAgencyDto(agencyRepository.save(newAgency));
            return newAgencyDto;



    }

    @Override
    public AgencyDto findByCode(Long code) throws AgencyNotFoundException {
        Agency agency = agencyRepository.findById(code).orElseThrow(() -> new AgencyNotFoundException(code));
        AgencyDto agencyDto = new AgencyDto();
        agencyDto=agencyConverter.toAgencyDto(agency);
        if(agency!=null)
        return agencyDto;
        else
            return null;
    }

    @Override
    public void delete(Long code)
    {
        Optional<Agency> agency = agencyRepository.findById(code);
        if (agency.isPresent())
        agencyRepository.delete(agency.get());
    }

    @Override
    public List<AgencyDto> findAll() {
        List<Agency> listAgency = new ArrayList<>();
        List<AgencyDto> listAgencyDto = new ArrayList<>();
        listAgency = agencyRepository.findAll();
        for (Agency agency : listAgency)
        {
            listAgencyDto.add(agencyConverter.toAgencyDto(agency));
        }
        return listAgencyDto;
    }
}
