package org.example;



import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {

        String username = "victory";
        String email = "qwerty@gmail.com";
        String password = "Password12@";
        int dob = 16;

        String validate = Validator.validate(username, email, password, dob);
        String validateConcurrently = ConcurrentValidator.validateConcurrently(username, email, password, dob);

        System.out.println("Validator: "+validate);
        System.out.println("Concurrent Validator: "+validateConcurrently);

        // Generate JWT token if validation passes
        if ("Validation passed".equals(validateConcurrently)) {
            String token = JWTUtil.generateToken(username);
            System.out.println("Generated Token: " + token);

            // Validate the generated token
            String validationResult = JWTUtil.validateToken(token);
            System.out.println("Token: "+validationResult);
        } else {
            System.out.println("Token verification failed");
        }
    }

}