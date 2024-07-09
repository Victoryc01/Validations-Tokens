import org.example.JWTUtil;
import org.junit.Test;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class JWTUtilTest {

    @Test
    public void testTokenGenerationAndValidation() {
        String username = "validUser";

        String token = JWTUtil.generateToken(username);

        String validationResult = JWTUtil.validateToken(token);
        assertEquals("Verification pass", validationResult, "Token should be valid");

    }

    @Test
    public void testInvalidTokenModification() {
        String username = "validUser";

        String token = JWTUtil.generateToken(username);

        String invalidToken = token + "invalidPart";

        String validationResult = JWTUtil.validateToken(invalidToken);
        assertTrue(validationResult.startsWith("Verification fails: "), "Token should be invalid");
    }

}
