package ma.atos.agency.exceptions;

import ma.atos.agency.enums.ExceptionsEnum;

public class InvalidRoleNameException extends Throwable {
    public InvalidRoleNameException(){
        super(ExceptionsEnum.INVALID_ROLE_NAME.getMessage());
    }

}
