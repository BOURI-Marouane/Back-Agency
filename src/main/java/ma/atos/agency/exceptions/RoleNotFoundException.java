package ma.atos.agency.exceptions;

import ma.atos.agency.enums.ExceptionsEnum;

public class RoleNotFoundException extends Exception {
    public RoleNotFoundException() {
        super(ExceptionsEnum.ROLE_NOT_FOUND.getMessage());
    }
}
