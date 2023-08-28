package com.lucasmancan.passwordapi;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/validations")
public class PasswordValidationController {

    @PostMapping("validate")
    public PasswordValidationResponse validate(@RequestParam String password) {

        boolean result = false;

        if (password.length() < 9) {
          return new PasswordValidationResponse(result);
        }

        if (!hasNumbers(password)) {
            return new PasswordValidationResponse(result);
        }

        if (!hasLowerCaseChars(password)) {
            return new PasswordValidationResponse(result);
        }

        if (!hasUpperCaseChars(password)) {
            return new PasswordValidationResponse(result);
        }

        if (!hasSpecialChars(password)) {
            return new PasswordValidationResponse(result);
        }

        if (hasRepetedChars(password)) {
            return new PasswordValidationResponse(result);
        }

        return new PasswordValidationResponse(true);
    }

    private boolean hasRepetedChars(String password) {
        return password.length() != password.chars().distinct().count();
    }

    private boolean hasSpecialChars(String password) {
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(password);
        return m.find();
    }

    public boolean hasLowerCaseChars(String password) {

        String[] chars = password.split("");
        for (int i = 0; i <= chars.length; i++) {
            if (Character.isLowerCase(chars[i].charAt(0))) {
                return true;
            }
        }

        return false;
    }


    public boolean hasUpperCaseChars(String password) {
        String[] chars = password.split("");
        for (int i = 0; i <= chars.length; i++) {
            if (Character.isUpperCase(chars[i].charAt(0))) {
                return true;
            }
        }

        return false;
    }

    public boolean hasNumbers(String password) {

        String[] chars = password.split("");
        for (int i = 0; i <= chars.length; i++) {
            try {
                Integer value = Integer.parseInt(chars[i]);
                return true;
            } catch (Exception e) {
                System.out.println("Erro ao converter char" + chars[i] + "para string");
            }
        }
        return true;
    }
}
