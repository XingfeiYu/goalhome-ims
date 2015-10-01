package com.yeahliving.goalhome.ims.constraint;

import com.yeahliving.goalhome.ims.bean.GoHoHouse;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created by xingfeiy on 9/30/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NotEmptySearchField.Validator.class, NotEmptySearchField.ListValidator.class})
public @interface NotEmptySearchField {
    String message() default "{com.yeahliving.goalhome.ims.constraint.NotEmptySearchField.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<NotEmptySearchField, GoHoHouse> {

        private UriInfo uriInfo;

        public Validator(@Context final UriInfo uriInfo) {
            this.uriInfo = uriInfo;
        }

        @Override
        public void initialize(final NotEmptySearchField hasId) {
        }

        @Override
        public boolean isValid(final GoHoHouse house, final ConstraintValidatorContext constraintValidatorContext) {
            final String searchType = uriInfo.getPathParameters().getFirst("searchType");
            final String searchValue = uriInfo.getQueryParameters().getFirst("q");

            if ("street".equals(searchType)) {
                return house.getAddress().getStreet() != null && house.getAddress().getStreet().contains(searchValue);
            } else if ("city".equals(searchType)) {
                return house.getAddress().getCity() != null && house.getAddress().getCity().contains(searchValue);
            } else {
//                return house.getFullName().contains(searchValue);
                return false;
            }
        }
    }

    public class ListValidator implements ConstraintValidator<NotEmptySearchField, List<GoHoHouse>> {

        @Context
        private UriInfo uriInfo;

        private Validator validator;

        @Override
        public void initialize(final NotEmptySearchField hasId) {
            validator = new Validator(uriInfo);
        }

        @Override
        public boolean isValid(final List<GoHoHouse> houses, final ConstraintValidatorContext constraintValidatorContext) {
            boolean isValid = true;
            for (final GoHoHouse house : houses) {
                isValid &= validator.isValid(house, constraintValidatorContext);
            }
            return isValid;
        }
    }
}
