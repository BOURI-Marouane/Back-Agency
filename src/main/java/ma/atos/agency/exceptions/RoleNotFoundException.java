package ma.atos.agency.exceptions;

public class RoleNotFoundException extends Exception {
    public RoleNotFoundException() {
        super(ExceptionsEnum.ROLE_NOT_FOUND.getMessage());
    }
}
