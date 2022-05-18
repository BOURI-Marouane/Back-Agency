package ma.atos.agency.dto.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class ReclamationDto {
        String label;
        String level;
        long   customer;
}
