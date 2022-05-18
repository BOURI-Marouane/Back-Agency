package ma.atos.agency.exceptions;

import ma.atos.agency.constantes.ConstanteAgency;

public class RoleNotFoundException extends Exception {

    public RoleNotFoundException(Long id) {
        super("Invalid Manager : Le Role que vous recherchez dont l'id est " + id + " est introuvable");

    public RoleNotFoundException() {
        super(ConstanteAgency.ROLE_NOT_FOUND);

    }
}
