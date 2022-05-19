package ma.atos.agency.exceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException (long id){
        super("Le compte vous recherchez dont l'id est "+id+" est introuvable");
    }
}

