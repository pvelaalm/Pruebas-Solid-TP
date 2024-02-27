package Ejercicio2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

class MainTest {

    @Test
    void testOrderCreation() {
        // Mocking user input
        String input = "1\nusuario1\npassword1\n2\nmiDireccion\npizzaHawaiana\n2\n5\nEfectivo\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Prepare users map
        Map<String, String> users = new HashMap<>();
        users.put("usuario1", "password1");

        // Run Main.main()
        Main.main(null);

        // No assertion here as we're just testing if the flow executes without error
    }

    @Test
    void testInvalidAuthentication() {
        // Mocking user input
        String input = "1\nusuario3\npassword3\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Prepare users map
        Map<String, String> users = new HashMap<>();
        users.put("usuario1", "password1");

        // Run Main.main()
        Main.main(null);

        // No assertion here as we're just testing if the flow executes without error
    }

    @Test
    void testPaymentProcessing() {
        // Mocking user input
        String input = "1\nusuario1\npassword1\n5\n10.0\nEfectivo\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Prepare users map
        Map<String, String> users = new HashMap<>();
        users.put("usuario1", "password1");

        // Run Main.main()
        Main.main(null);

        // No assertion here as we're just testing if the flow executes without error
    }
}
