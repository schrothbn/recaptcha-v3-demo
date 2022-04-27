package com.example.recaptchademo.model;

import com.example.recaptchademo.constraints.CaptchaValid;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Java bean representing a contact form with validation.
 * @author DevBearliah
 */
public class ContactForm {
    @NotBlank(message = "Please enter a name")
    private String name;
    @NotBlank(message = "Please enter an e-mail address")
    @Email(message = "Please enter an valid e-mail address")
    private String email;
    private String subject;
    @NotBlank(message = "Please enter a message")
    private String message;
    @CaptchaValid
    private String recaptchaToken;
    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getRecaptchaToken() {
        return recaptchaToken;
    }

    public void setRecaptchaToken(String recaptchaToken) {
        this.recaptchaToken = recaptchaToken;
    }

}
