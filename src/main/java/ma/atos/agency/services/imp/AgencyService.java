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



    @Autowired  AgencyConverter agencyConverter;


    @Override
    public AgencyDto newAgency(AgencyDto agencyDto) {
        AgencyDto agencyDtoNew = new AgencyDto();

        //agencyDtoNew.setEnabled(true);

        agencyDtoNew.setStatus(true);

        Agency agency= agencyRepository.save(agencyConverter.toAgency(agencyDto));
        agencyDtoNew=agencyConverter.toAgencyDto(agency);
        return agencyDtoNew;
    }

    // first param (agency_A) pour fussione en en deuxieme parametre
    @Override
    public AgencyDto fussione(Long agency_A, Long agency_B) {

        Agency agencyA = new Agency();
        agencyA = agencyRepository.findByCode(agency_A);
        Agency agencyB = agencyRepository.findByCode(agency_B);
        agencyA.setEnabled(false);
        Agency agencyNew = agencyRepository.save(agencyA);
        ///////////////////////////////////////////////
        List<Gestionnaire> listGestionnaire = agencyA.getGestionnaires();

        agencyB.setGestionnaires(agencyA.getGestionnaires());

        AgencyDto agencyDto = agencyConverter.toAgencyDto(agencyB);


        Optional<Agency> agencyToBeClosed = agencyRepository.findById(agency_A);

        if (!agencyToBeClosed.isPresent()) {

            // THROWS CUSTOME EXCEPTIP?
        }

        Optional<Agency> agencyToBeMerged = agencyRepository.findById(agency_A);

        if (!agencyToBeMerged.isPresent()) {
            // TRHOWS CUSTOM EXCEPTION
        }

        agencyToBeClosed.get().setStatus(false);



        return agencyDto;
    }

    @Override
    public AgencyDto update(AgencyDto agencyDto) {

        Agency agency = agencyConverter.toAgency(agencyDto);
        Agency newAgency = agencyRepository.findByCode(agency.getCode());
        if(newAgency != null)
        {
            newAgency.setName(agency.getName());
            newAgency.setCode(agency.getCode());
            newAgency.setGestionnaires(agency.getGestionnaires());
            newAgency.setAdress(agency.getAdress());
            AgencyDto newAgencyDto = agencyConverter.toAgencyDto(agencyRepository.save(newAgency));
            return newAgencyDto;
        }
        else
            return null;
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
        Agency agency = agencyRepository.findByCode(code);
        agencyRepository.delete(agency);
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
