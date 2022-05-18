package ma.atos.agency.exceptions;

import ma.atos.agency.constantes.ConstanteAgency;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(){
        super(ConstanteAgency.CLIENT_NOT_FOUND);
    }
}
