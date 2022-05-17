package ma.atos.agency.exceptions;


public class PrivilegeNotFoundException extends Exception{
    public PrivilegeNotFoundException(Long id){
        super("Invalid Manager : Le privilege que vous recherchez dont l'id est "+id+" est introuvable");

public class PrivilegeNotFoundException extends Exception {
    public PrivilegeNotFoundException(){
        super(ExceptionsEnum.PRIVILEGE_NOT_FOUND.getMessage());

    }
}
