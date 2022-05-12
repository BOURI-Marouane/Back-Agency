package ma.atos.agency.exceptions;

public class PrivilegeNotFoundException extends Exception{
    public PrivilegeNotFoundException(Long id){
        super("Le privilege que vous recherchez dont l'id est "+id+" est introuvable");
    }
}
