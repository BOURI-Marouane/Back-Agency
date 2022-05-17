package ma.atos.agency.exceptions;

public class ManagerNotFoundException extends Exception{
    public ManagerNotFoundException(Long code)
    {
        super("Invalid Manager : The manager you are looking for whose id is " + code + " could not be found");
    }
}
