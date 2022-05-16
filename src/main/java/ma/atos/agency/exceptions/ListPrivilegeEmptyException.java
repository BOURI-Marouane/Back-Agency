package ma.atos.agency.exceptions;

import ma.atos.agency.enums.ExceptionsEnum;

public class ListPrivilegeEmptyException extends Exception {
    public ListPrivilegeEmptyException(){
        super(ExceptionsEnum.PRIVILEGE_LIST_EMPTY.getMessage());
    }

}
