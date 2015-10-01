package com.yeahliving.goalhome.ims.constraint;

import com.yeahliving.goalhome.ims.bean.GoHoEmployeeLander;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created by xingfeiy on 9/29/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {HasEmployeeName.Validator.class, HasEmployeeName.ListValidator.class})
public @interface HasEmployeeName {
    String message() default "{com.yeahliving.goalhome.ims.constraint.HasEmployeeName.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<HasEmployeeName, GoHoEmployeeLander> {

        @Override
        public void initialize(final HasEmployeeName hasName) {
        }

        @Override
        public boolean isValid(final GoHoEmployeeLander lander, final ConstraintValidatorContext constraintValidatorContext) {
            return lander == null || lander.getUser_name() != null;
        }
    }

    public class ListValidator implements ConstraintValidator<HasEmployeeName, List<GoHoEmployeeLander>>  {

        private Validator validator = new Validator();

        @Override
        public void initialize(final HasEmployeeName hasName) {
        }

        @Override
        public boolean isValid(final List<GoHoEmployeeLander> landers, final ConstraintValidatorContext constraintValidatorContext) {
            boolean isValid = true;
            for (final GoHoEmployeeLander lander : landers) {
                isValid &= validator.isValid(lander, constraintValidatorContext);
            }
            return isValid;
        }
    }
}
