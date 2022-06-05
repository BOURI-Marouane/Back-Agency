package ma.atos.agency.services;

import ma.atos.agency.dto.AgencyDto;

import ma.atos.agency.exceptions.AgencyNotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface IAgencyService {

    AgencyDto newAgency(AgencyDto agencyDto);
    AgencyDto fussione(Long agency_A,Long Agency_B);
    AgencyDto update(AgencyDto agencyDto) throws AgencyNotFoundException;

    AgencyDto findByCode(Long code) throws AgencyNotFoundException;

    void delete(Long code) throws AgencyNotFoundException;

    List<AgencyDto> findAll();


}
