package ru.niatomi.model.validation;

import ru.niatomi.model.validation.validator.DateLessThanValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author niatomi
 */
@Constraint(validatedBy = DateLessThanValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateLessThan {

    String message() default "time1 должно быть меньше, чем time2";

    String time1();

    String time2();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        DateLessThan[] value();
    }

    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}