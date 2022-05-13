package ma.atos.agency.exceptions;

public class PrivilegeNameInvalidException extends Exception{

    public PrivilegeNameInvalidException(){
        super("Invalid Privilege: must match configuration privileges ");
    }
}
