package com.example.recaptchademo.services;

import com.example.recaptchademo.model.recaptcha.ReCaptchaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReCaptchaService {
    private static final String CHECK_URL = "https://www.google.com/recaptcha/api/siteverify";
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${recaptcha.secret_key}")
    private String secret;


    public boolean verify(String token) {
        String url = CHECK_URL+String.format("?secret=%s&response=%s", secret, token);
        var response = restTemplate.getForObject(url, ReCaptchaResponse.class);

        // Verification was successful
        if (response != null && response.isSuccess()) {
            return response.getScore() >= 0.5;
        }
        // Connection failed
        return false;
    }


}
