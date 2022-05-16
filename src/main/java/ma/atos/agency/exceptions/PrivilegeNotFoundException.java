package ma.atos.agency.exceptions;

import ma.atos.agency.enums.ExceptionsEnum;

import java.util.function.Supplier;

public class PrivilegeNotFoundException extends Exception {
    public PrivilegeNotFoundException(){
        super(ExceptionsEnum.PRIVILEGE_NOT_FOUND.getMessage());
    }
}
