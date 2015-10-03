package com.yeahliving.goalhome.ims.constraint;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by xingfeiy on 10/2/15.
 */
@Max(value = -1, message = "{database_failed}")
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ReturnValidId.Validator.class)
public @interface ReturnValidId {
    String message() default "{com.yeahliving.goalhome.ims.constraint.ReturnValidId.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<ReturnValidId, Integer> {

        @Override
        public void initialize(final ReturnValidId hasName) {
        }

        @Override
        public boolean isValid(final Integer id, final ConstraintValidatorContext constraintValidatorContext) {
            return id > 0;
        }
    }
}
