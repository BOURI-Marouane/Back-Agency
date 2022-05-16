package ma.atos.agency.exceptions;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(Long id){
        super(ExceptionsEnum.CLIENT_NOT_FOUND.getMessage());
    }
}
