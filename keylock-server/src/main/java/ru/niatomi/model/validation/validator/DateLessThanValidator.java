package ru.niatomi.model.validation.validator;

import org.springframework.beans.BeanWrapperImpl;
import ru.niatomi.model.validation.DateLessThan;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
 * @author niatomi
 */
public class DateLessThanValidator implements ConstraintValidator<DateLessThan, Object> {

    private String time1;
    private String time2;

    @Override
    public void initialize(DateLessThan constraintAnnotation) {
        this.time1 = constraintAnnotation.time1();
        this.time2 = constraintAnnotation.time2();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Object fieldValue_1 = new BeanWrapperImpl(value)
                .getPropertyValue(time1);
        Object fieldValue_2 = new BeanWrapperImpl(value)
                .getPropertyValue(time2);

        if (fieldValue_2 == null) {
            return true;
        }

        LocalDate compairingTime1 = LocalDate.parse(fieldValue_1.toString());
        LocalDate compairingTime2 = LocalDate.parse(fieldValue_2.toString());

        if (compairingTime1 != null) {
            return compairingTime1.isBefore(compairingTime2);
        } else {
            return compairingTime1 == null;
        }

    }
}
