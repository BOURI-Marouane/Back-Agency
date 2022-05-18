package ma.atos.agency.exceptions;

import ma.atos.agency.constantes.ConstanteAgency;

public class InvalidRoleNameException extends Throwable {
    public InvalidRoleNameException(){
        super(ConstanteAgency.INVALID_ROLE_NAME);
    }

}
