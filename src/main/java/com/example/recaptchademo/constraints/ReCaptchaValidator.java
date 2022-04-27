package com.example.recaptchademo.constraints;

import com.example.recaptchademo.services.ReCaptchaService;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ReCaptchaValidator implements ConstraintValidator<CaptchaValid, String> {
    private final ReCaptchaService reCaptchaService;

    public ReCaptchaValidator(ReCaptchaService reCaptchaService) {
        this.reCaptchaService = reCaptchaService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return reCaptchaService.verify(value);
    }
}
