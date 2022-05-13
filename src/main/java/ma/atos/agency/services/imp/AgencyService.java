package ma.atos.agency.services.imp;

import ma.atos.agency.dto.AgencyDto;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.entities.Gestionnaire;
import ma.atos.agency.mappers.AgencyConverter;
import ma.atos.agency.repositories.AgencyRepository;
import ma.atos.agency.services.IAgencyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AgencyService implements IAgencyService {
    @Autowired
    AgencyRepository agencyRepository;
    @Override
    public AgencyDto newAgency(AgencyDto agencyDto) {
        AgencyDto agencyDtoNew = new AgencyDto();
        agencyDtoNew.setStatus(true);
        Agency agency= agencyRepository.save(AgencyConverter.toAgency(agencyDto));
        agencyDtoNew=AgencyConverter.toAgencyDto(agency);
        return agencyDtoNew;
    }

    // first param (agency_A) pour fussione en en deuxieme parametre
    @Override
    public AgencyDto fussione(Long agency_A, Long agency_B) {
        Agency agencyA = new Agency();
        agencyA = agencyRepository.findByCode(agency_A);
        Agency agencyB = agencyRepository.findByCode(agency_B);
        agencyA.setStatus(false);
        Agency agencyNew = agencyRepository.save(agencyA);
        ///////////////////////////////////////////////
        List<Gestionnaire> listGestionnaire = agencyA.getList();

        agencyB.setList(agencyA.getList());

        AgencyDto agencyDto = AgencyConverter.toAgencyDto(agencyB);

        return agencyDto;
    }

    @Override
    public AgencyDto update(AgencyDto agencyDto) {

        Agency agency = AgencyConverter.toAgency(agencyDto);
        Agency newAgency = agencyRepository.findByCode(agency.getCode());
        if(newAgency != null)
        {
            newAgency.setName(agency.getName());
            newAgency.setCode(agency.getCode());
            newAgency.setList(agency.getList());
            newAgency.setAdress(agency.getAdress());
            AgencyDto newAgencyDto = AgencyConverter.toAgencyDto(agencyRepository.save(newAgency));
            return newAgencyDto;
        }
        else
            return null;
    }

    @Override
    public AgencyDto findByCode(Long code) {
        Agency agency = agencyRepository.findByCode(code);
        AgencyDto agencyDto = new AgencyDto();
        agencyDto=AgencyConverter.toAgencyDto(agency);
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
