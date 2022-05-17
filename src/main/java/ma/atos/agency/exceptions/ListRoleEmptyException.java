package ma.atos.agency.exceptions;

public class ListRoleEmptyException extends Exception{
    public ListRoleEmptyException(){
        super(ExceptionsEnum.ROLE_LIST_EMPTY.getMessage());
    }

}
