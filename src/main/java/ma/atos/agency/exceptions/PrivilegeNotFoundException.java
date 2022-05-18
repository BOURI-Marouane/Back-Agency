package ma.atos.agency.exceptions;

import ma.atos.agency.constantes.ConstanteAgency;

public class PrivilegeNotFoundException extends Exception {
    public PrivilegeNotFoundException(){
        super(ConstanteAgency.PRIVILEGE_NOT_FOUND);


    }
}
