package ma.atos.agency.exceptions;

public class RoleNotFoundException extends Exception {

    public RoleNotFoundException(Long id) {
        super("Invalid Manager : Le Role que vous recherchez dont l'id est " + id + " est introuvable");

    public RoleNotFoundException() {
        super(ExceptionsEnum.ROLE_NOT_FOUND.getMessage());

    }
}
