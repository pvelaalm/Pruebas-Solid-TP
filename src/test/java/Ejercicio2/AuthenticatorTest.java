package Ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

class AuthenticatorTest {

    @Test
    void testAuthenticationSuccess() {
        // Prepare test data
        String username = "usuario1";
        String password = "password1";
        String expectedPassword = "password1";

        // Prepare user storage
        Map<String, String> users = new HashMap<>();
        users.put(username, expectedPassword);
        UserStorage userStorage = new HashMapUserStorage(users);

        // Create Authenticator instance
        Authenticator authenticator = new Authenticator(userStorage);

        // Perform authentication
        boolean result = authenticator.authenticate(username, password);

        // Assertion
        assertTrue(result, "Authentication should succeed with correct credentials");
    }

    @Test
    void testAuthenticationFailure() {
        // Prepare test data
        String username = "usuario1";
        String password = "password1";
        String incorrectPassword = "incorrectPassword";

        // Prepare user storage
        Map<String, String> users = new HashMap<>();
        users.put(username, password);
        UserStorage userStorage = new HashMapUserStorage(users);

        // Create Authenticator instance
        Authenticator authenticator = new Authenticator(userStorage);

        // Perform authentication with incorrect password
        boolean result = authenticator.authenticate(username, incorrectPassword);

        // Assertion
        assertFalse(result, "Authentication should fail with incorrect password");
    }

    @Test
    void testInvalidUsername() {
        // Prepare test data
        String username = "usuario1";
        String password = "password1";
        String invalidUsername = "invalidUser";

        // Prepare user storage
        Map<String, String> users = new HashMap<>();
        users.put(username, password);
        UserStorage userStorage = new HashMapUserStorage(users);

        // Create Authenticator instance
        Authenticator authenticator = new Authenticator(userStorage);

        // Perform authentication with invalid username
        boolean result = authenticator.authenticate(invalidUsername, password);

        // Assertion
        assertFalse(result, "Authentication should fail with invalid username");
    }

    @Test
    void testNullUserStorage() {
        // Prepare test data
        String username = "usuario1";
        String password = "password1";

        // Create Authenticator instance with null UserStorage (invalid state)
        Authenticator authenticator = new Authenticator(null);

        // Perform authentication
        boolean result = authenticator.authenticate(username, password);

        // Assertion
        assertFalse(result, "Authentication should fail with null UserStorage");
    }
}
