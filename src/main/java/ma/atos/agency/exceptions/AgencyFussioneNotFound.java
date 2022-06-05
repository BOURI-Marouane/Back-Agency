package ma.atos.agency.exceptions;

public class AgencyFussioneNotFound extends Exception{

    public AgencyFussioneNotFound(Long code_A,Long code_B)
    {
        super("Invalid Agency : The agency you are looking for whose id is " + code_A + " or " +code_B+ " could not be found");
    }


}
