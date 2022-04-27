package com.example.recaptchademo.constraints;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ReCaptchaValidator.class)
@Documented
public @interface CaptchaValid {
    String message() default "Invalid captcha";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
