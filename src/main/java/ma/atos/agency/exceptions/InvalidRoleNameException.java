package ma.atos.agency.exceptions;

public class InvalidRoleNameException extends Throwable {
    public InvalidRoleNameException(){
        super(ExceptionsEnum.INVALID_ROLE_NAME.getMessage());
    }

}
