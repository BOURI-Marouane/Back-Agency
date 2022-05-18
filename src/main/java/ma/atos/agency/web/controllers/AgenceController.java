package ma.atos.agency.web.controllers;

import ma.atos.agency.dto.AgencyDto;
import ma.atos.agency.exceptions.AgencyFussioneNotFound;
import ma.atos.agency.exceptions.AgencyNotFoundException;
import ma.atos.agency.mappers.AgencyConverter;
import ma.atos.agency.services.imp.AgencyService;
import ma.atos.agency.web.dto.Request.AgencyRequestDto;
import ma.atos.agency.web.dto.Response.AgencyResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgenceController {

    @Autowired
    private AgencyService agencyService;

    @Autowired
    AgencyConverter agencyConverter;

    @PostMapping("/save")
    private ResponseEntity<AgencyResponseDto> createAgency(@Valid @RequestBody AgencyRequestDto agencyRequestDto)
    {
        AgencyResponseDto agencyResponseDto = null;
        try {
             agencyResponseDto = agencyConverter.ToResponseAgencyDto(agencyService.newAgency(agencyConverter.RequestToAgencyDto(agencyRequestDto)));
             agencyResponseDto.setHttpStatus(String.valueOf(HttpStatus.CREATED));
             agencyResponseDto.setMessage("Entity is successful created");

            return  ResponseEntity.ok().body(agencyResponseDto);
        } catch (Exception e)
        {
            agencyResponseDto.setHttpStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            agencyResponseDto.setMessage("Erreur technique est survenue. Veuillez contacter votre administrateur");
            return ResponseEntity.badRequest().body(agencyResponseDto);
        }
    }



    @PostMapping("/findByCode")
    private AgencyResponseDto findByCode(@RequestBody Long code) throws AgencyNotFoundException
    {
        try {
            return agencyConverter.ToResponseAgencyDto(agencyService.findByCode(code));
        }
        catch (Exception e)
        {
            throw new AgencyNotFoundException(code);
        }
    }

    @PostMapping("/fussione")
    private AgencyResponseDto fussione(@RequestBody Long CodeagencyDto1,@RequestBody Long CodeagencyDto2) throws AgencyFussioneNotFound
    {
        try {
            return agencyConverter.ToResponseAgencyDto(agencyService.fussione(CodeagencyDto1,CodeagencyDto2));
        }
        catch (Exception e)
        {
            throw new AgencyFussioneNotFound(CodeagencyDto1,CodeagencyDto2);
        }
    }

    @RequestMapping("/delete")
    private void delete(@RequestBody Long code) throws AgencyNotFoundException
    {
        try {
            agencyService.delete(code);
        }
        catch (Exception e)
        {
            throw new AgencyNotFoundException(code);
        }
    }

    @PostMapping("/update")
    private ResponseEntity<AgencyResponseDto> update(@Valid @RequestBody AgencyRequestDto agencyRequestDto)
    {
            AgencyResponseDto agencyResponseDto = agencyConverter.ToResponseAgencyDto(agencyService.update(agencyConverter.RequestToAgencyDto(agencyRequestDto)));
        return new ResponseEntity<AgencyResponseDto>(agencyResponseDto,HttpStatus.CREATED);

    }

    @PostMapping("/all")
    private List<AgencyResponseDto> findAll()
    {
        List<AgencyDto> listAgencyDto = agencyService.findAll();
        List<AgencyResponseDto> lisResponseAgency = new ArrayList<>();
        for(AgencyDto agencyDto : listAgencyDto)
        {
            lisResponseAgency.add(agencyConverter.ToResponseAgencyDto(agencyDto));
        }
        return lisResponseAgency;
    }




}
