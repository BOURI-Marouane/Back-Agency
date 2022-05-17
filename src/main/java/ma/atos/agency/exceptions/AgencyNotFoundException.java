package ma.atos.agency.exceptions;

public class AgencyNotFoundException extends Exception{

    public AgencyNotFoundException(Long code)
    {
        super("Invalid Manager : The agency you are looking for whose id is " + code + " could not be found");
    }


}
