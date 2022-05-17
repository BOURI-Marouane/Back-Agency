package ma.atos.agency.exceptions;

public class ManagerNameInvalidException extends Exception{

    public ManagerNameInvalidException()
    {
        super("Invalid Manager : must match configuration managers");
    }

}
