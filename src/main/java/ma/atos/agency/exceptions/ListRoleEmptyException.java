package ma.atos.agency.exceptions;

import ma.atos.agency.constantes.ConstanteAgency;

public class ListRoleEmptyException extends Exception{
    public ListRoleEmptyException(){
        super(ConstanteAgency.ROLE_LIST_EMPTY);
    }

}
