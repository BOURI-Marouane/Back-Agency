package ma.atos.agency.exceptions;

public class AgencyNameInvalidException extends Exception{

    public AgencyNameInvalidException()
    {
        super("Invalid Agency : must match configuration agency");
    }
}
