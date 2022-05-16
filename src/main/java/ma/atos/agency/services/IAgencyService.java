package ma.atos.agency.services;

import ma.atos.agency.dto.AgencyDto;
import org.springframework.stereotype.Service;

@Service
public interface IAgencyService {

    AgencyDto newAgency(AgencyDto agencyDto);
    AgencyDto fussione(Long agency_A,Long Agency_B);
    AgencyDto update(AgencyDto agencyDto);

    AgencyDto findByCode(Long code);

    void delete(Long code);


}
