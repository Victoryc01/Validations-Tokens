package org.example;


import java.util.regex.Pattern;

public class Validator {

    public static boolean isUsernameValid(String username){
        return username != null &&  username.length() >= 4;
    }

    public static boolean isEmailValid(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return email != null && pat.matcher(email).matches();
    }

    public static boolean isPasswordValid(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*\\d).{8,}$";
        Pattern pat = Pattern.compile(passwordRegex);
        return password != null && pat.matcher(password).matches();
    }

    public static boolean isDobValid(Integer dob){
      //  return  dob >= 16;
        return dob != null && dob >= 16;
    }

    public static String validate(String username, String email, String password, int dob) {
        StringBuilder validationErrors = new StringBuilder();

        if (!isUsernameValid(username)) {
            validationErrors.append("Username: should not empty and min 4 characters\n");
        }
        if (!isEmailValid(email)) {
            validationErrors.append("Email: should not empty and a valid email address\n");
        }
        if (!isPasswordValid(password)) {
            validationErrors.append("Password: not a strong password\n");
        }
        if (!isDobValid(dob)) {
            validationErrors.append("Date of Birth: should be 16 years or greater\n");
        }

        return validationErrors.isEmpty() ? "Validation passed" : validationErrors.toString();
    }


































//
//    E. JUnit Test Case
//
//    JUnit Test:
//
//            import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//    public class JWTUtilTest {
//
//        @Test
//        public void testTokenGenerationAndValidation() {
//            String username = "validUser";
//            String token = JWTUtil.generateToken(username);
//
//            assertEquals("Verification pass", JWTUtil.validateToken(token), "Token should be valid");
//
//            // Altering the token to make it invalid
//            String invalidToken = token + "invalidPart";
//            assertEquals("Verification fails", JWTUtil.validateToken(invalidToken), "Token should be invalid");
//        }
//    }

}
