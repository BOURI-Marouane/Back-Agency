package ma.atos.agency.exceptions;

public class RoleNameInvalidExeption extends Exception{

    public RoleNameInvalidExeption(){
        super("Invalid Role: must match configuration roles ");
    }
}
