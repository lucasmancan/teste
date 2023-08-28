package com.lucasmancan.passwordapi;

public class PasswordValidationResponse {
    private boolean valid;

    public PasswordValidationResponse(boolean valid){
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
