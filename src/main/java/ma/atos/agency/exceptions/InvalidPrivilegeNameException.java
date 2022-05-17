package ma.atos.agency.exceptions;

public class InvalidPrivilegeNameException extends Exception {
    public InvalidPrivilegeNameException(){
        super(ExceptionsEnum.INVALID_PRIVILEGE_NAME.getMessage());
    }
}
