package ma.atos.agency.exceptions;

import ma.atos.agency.enums.ExceptionsEnum;

public class InvalidPrivilegeNameException extends Exception {
    public InvalidPrivilegeNameException(){
        super(ExceptionsEnum.INVALID_PRIVILEGE_NAME.getMessage());
    }
}
