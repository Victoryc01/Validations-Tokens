package org.example;


import java.util.concurrent.CompletableFuture;


public class ConcurrentValidator {

    public static String validateConcurrently(String username, String email, String password, int dob) {

        CompletableFuture<Boolean> usernameFuture = CompletableFuture.supplyAsync(() -> Validator.isUsernameValid(username));
        CompletableFuture<Boolean> emailFuture = CompletableFuture.supplyAsync(() -> Validator.isEmailValid(email));
        CompletableFuture<Boolean> passwordFuture = CompletableFuture.supplyAsync(() -> Validator.isPasswordValid(password));
        CompletableFuture<Boolean> dobFuture = CompletableFuture.supplyAsync(() -> Validator.isDobValid(dob));

        CompletableFuture<Void> allOf = CompletableFuture.allOf(usernameFuture, emailFuture, passwordFuture, dobFuture);
        allOf.join();

        boolean isUsernameValid = usernameFuture.join();
        boolean isEmailValid = emailFuture.join();
        boolean isPasswordValid = passwordFuture.join();
        boolean isDobValid = dobFuture.join();

        StringBuilder validationErrors = new StringBuilder();

        if (!isUsernameValid) {
            validationErrors.append("Username: should not be empty and min 4 characters\n");
        }
        if (!isEmailValid) {
            validationErrors.append("Email: should not be empty and a valid email address\n");
        }
        if (!isPasswordValid) {
            validationErrors.append("Password: not a strong password\n");
        }
        if (!isDobValid) {
            validationErrors.append("Date of Birth: should be 16 years or greater\n");
        }

        return validationErrors.isEmpty() ? "Validation passed": validationErrors.toString();

    }

}
