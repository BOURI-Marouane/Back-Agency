package ma.atos.agency.exceptions;

import ma.atos.agency.constantes.ConstanteAgency;

public class InvalidPrivilegeNameException extends Exception {
    public InvalidPrivilegeNameException(){
        super(ConstanteAgency.INVALID_PRIVILEGE_NAME);
    }
}
