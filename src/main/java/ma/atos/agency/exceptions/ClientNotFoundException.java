package ma.atos.agency.exceptions;

import ma.atos.agency.enums.ExceptionsEnum;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(Long id){
        super(ExceptionsEnum.CLIENT_NOT_FOUND.getMessage());
    }
}
