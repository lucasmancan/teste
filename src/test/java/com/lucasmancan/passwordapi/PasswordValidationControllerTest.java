package com.lucasmancan.passwordapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidationControllerTest {

    PasswordValidationController passwordValidationController = new PasswordValidationController();

    @Test
    public void shouldValidatePassword() {

        String invalidPassword = "LUCAS";

        PasswordValidationResponse result = passwordValidationController.validate(invalidPassword);

        assertFalse(result.isValid());

    }

    @Test
    public void shouldValidateValidPassword() {

        String invalidPassword = "Ar@o1234567";

        PasswordValidationResponse result = passwordValidationController.validate(invalidPassword);

        assertTrue(result.isValid());
    }
}
