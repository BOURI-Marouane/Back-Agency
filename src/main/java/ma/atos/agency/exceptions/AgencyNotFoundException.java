package ma.atos.agency.exceptions;

import lombok.Data;
import org.apache.http.HttpStatus;

@Data
public class AgencyNotFoundException extends Exception{

    public AgencyNotFoundException(String message)
    {
        super(message);
    }

    private HttpStatus httpStatus;

}
