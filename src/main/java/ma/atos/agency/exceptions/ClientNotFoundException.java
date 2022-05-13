package ma.atos.agency.exceptions;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(Long id){
        super("Le client que vous cherchez dont l'id est " + id + "est introuvable");
    }
}
