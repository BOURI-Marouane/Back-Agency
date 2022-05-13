package ma.atos.agency.annotations.role;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;


@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RoleValidator.class)
public @interface RoleValidation {
    public String message() default "Invalid Role: must match configuration roles";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
