package ma.atos.agency.exceptions;

import ma.atos.agency.constantes.ConstanteAgency;

public class ListPrivilegeEmptyException extends Exception {
    public ListPrivilegeEmptyException(){
        super(ConstanteAgency.PRIVILEGE_LIST_EMPTY);
    }

}
