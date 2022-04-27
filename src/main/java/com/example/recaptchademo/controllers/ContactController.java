package com.example.recaptchademo.controllers;

import com.example.recaptchademo.model.ContactForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ContactController {
    @Value("${recaptcha.site_key}")
    private String captchaSiteKey;
    @GetMapping("/contact")
    public String renderContact(Model model) {
        model.addAttribute("form", new ContactForm());
        model.addAttribute("captchaSiteKey", captchaSiteKey);
        return "contact";
    }

    @PostMapping("/contact")
    public String processContact(@Valid @ModelAttribute("form") final ContactForm form,
                                 final BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("captchaSiteKey", captchaSiteKey);
            model.addAttribute("form", form);
            return "contact";
        }
        // do submission
        return "success";
    }
}
