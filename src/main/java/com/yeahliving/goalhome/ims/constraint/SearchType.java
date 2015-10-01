package com.yeahliving.goalhome.ims.constraint;

import javax.validation.Payload;

/**
 * Created by xingfeiy on 9/30/15.
 */
public @interface SearchType {
    String message() default "{com.yeahliving.goalhome.ims.constraint.SearchType.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
