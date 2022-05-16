package ma.atos.agency.exceptions;

public class PrivilegeNotFoundException extends Exception {
    public PrivilegeNotFoundException(){
        super(ExceptionsEnum.PRIVILEGE_NOT_FOUND.getMessage());
    }
}
