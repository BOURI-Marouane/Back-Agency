package ma.atos.agency.handlers;

import ma.atos.agency.exceptions.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.lang.reflect.Array;
import java.util.*;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(AgencyNameInvalidException.class)
    @ResponseBody
    public ResponseEntity<List> processAgencyUnmergeException(final AgencyNameInvalidException e)
    {
        return new ResponseEntity<>(Arrays.asList(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ManagerNameInvalidException.class)
    @ResponseBody
    public ResponseEntity<List> processManagerUnmergeException(final ManagerNameInvalidException e)
    {
        return new ResponseEntity<>(Arrays.asList(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AgencyNotFoundException.class)
    @ResponseBody
    public ResponseEntity<List> processAgencyUnmergeException(final AgencyNotFoundException e)
    {
        return new ResponseEntity<>(Arrays.asList(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ManagerNotFoundException.class)
    @ResponseBody
    public ResponseEntity<List> processManagerUnmergeException(final ManagerNotFoundException e)
    {
       return new ResponseEntity<>(Arrays.asList(e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AgencyFussioneNotFound.class)
    @ResponseBody
    public ResponseEntity<List> processAgencyFussioneUnmergerException(final AgencyFussioneNotFound e)
    {
        return new ResponseEntity<>(Arrays.asList(e.getMessage()),HttpStatus.BAD_REQUEST);
    }





}
