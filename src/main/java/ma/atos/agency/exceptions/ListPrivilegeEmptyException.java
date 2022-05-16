package ma.atos.agency.exceptions;

public class ListPrivilegeEmptyException extends Exception {
    public ListPrivilegeEmptyException(){
        super(ExceptionsEnum.PRIVILEGE_LIST_EMPTY.getMessage());
    }

}
