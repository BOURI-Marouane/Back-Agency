package ma.atos.agency.exceptions;

import ma.atos.agency.constantes.ConstanteAgency;

public class RoleNotFoundException extends Exception {
    public RoleNotFoundException() {
        super(ConstanteAgency.ROLE_NOT_FOUND);
    }
}
