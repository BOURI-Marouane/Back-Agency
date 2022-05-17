package ma.atos.agency.exceptions;

public class PrivilegeNotFoundException extends Exception{
    public PrivilegeNotFoundException(Long id){
        super("Invalid Manager : Le privilege que vous recherchez dont l'id est "+id+" est introuvable");
    }
}
