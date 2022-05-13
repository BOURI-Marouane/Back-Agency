package ma.atos.agency.handlers;
import ma.atos.agency.exceptions.PrivilegeNameInvalidException;
import ma.atos.agency.exceptions.PrivilegeNotFoundException;
import ma.atos.agency.exceptions.RoleNameInvalidExeption;
import ma.atos.agency.exceptions.RoleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(RoleNameInvalidExeption.class)
    @ResponseBody
    public ResponseEntity<List> processRoleUnmergeException(final RoleNameInvalidExeption ex) {

        return new ResponseEntity<>(Arrays.asList(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PrivilegeNameInvalidException.class)
    @ResponseBody
    public ResponseEntity<List> processPrivilegeUnmergeException(final PrivilegeNameInvalidException ex) {

        return new ResponseEntity<>(Arrays.asList(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}