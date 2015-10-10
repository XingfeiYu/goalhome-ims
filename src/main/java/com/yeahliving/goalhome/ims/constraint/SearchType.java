package com.yeahliving.goalhome.ims.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by xingfeiy on 9/30/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@Pattern(regexp = "(street|city|district|complex|province|keywords|available|agent|nearby|all)")
@ReportAsSingleViolation
@Constraint(validatedBy = {})
public @interface SearchType {
    String message() default "{com.yeahliving.goalhome.ims.constraint.SearchType.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
