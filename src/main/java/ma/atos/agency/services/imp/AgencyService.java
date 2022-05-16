package ma.atos.agency.services.imp;

import ma.atos.agency.dto.AgencyDto;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.entities.Gestionnaire;
import ma.atos.agency.mappers.AgencyConverter;
import ma.atos.agency.repositories.AgencyRepository;
import ma.atos.agency.services.IAgencyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AgencyService implements IAgencyService {
    @Autowired
    AgencyRepository agencyRepository;

    @Autowired  AgencyConverter agencyConverter;

    @Override
    public AgencyDto newAgency(AgencyDto agencyDto) {
        AgencyDto agencyDtoNew = new AgencyDto();
        agencyDtoNew.setStatus(true);
        Agency agency= agencyRepository.save(agencyConverter.toAgency(agencyDto));
        agencyDtoNew=agencyConverter.toAgencyDto(agency);
        return agencyDtoNew;
    }

    // first param (agency_A) pour fussione en en deuxieme parametre
    @Override
    public AgencyDto fussione(Long agency_A, Long agency_B) {

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
            newAgency.setList(agency.getList());
            newAgency.setAdress(agency.getAdress());
            AgencyDto newAgencyDto = agencyConverter.toAgencyDto(agencyRepository.save(newAgency));
            return newAgencyDto;
        }
        else
            return null;
    }

    @Override
    public AgencyDto findByCode(Long code) {
        Agency agency = agencyRepository.findByCode(code);
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
}
