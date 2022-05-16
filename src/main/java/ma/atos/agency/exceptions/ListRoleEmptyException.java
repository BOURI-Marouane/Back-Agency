package ma.atos.agency.exceptions;

import ma.atos.agency.enums.ExceptionsEnum;

public class ListRoleEmptyException extends Exception{
    public ListRoleEmptyException(){
        super(ExceptionsEnum.ROLE_LIST_EMPTY.getMessage());
    }

}
