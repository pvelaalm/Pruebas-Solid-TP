package Ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.HashMap;


public class UserStorageTest {
    private UserStorage userStorage;

    @BeforeEach
    void setUp() {
        userStorage = new HashMapUserStorage(new HashMap<>());
    }

    @Test
    void testGetPassword() {
        String username = "usuario1";
        String password = "password1";

        // Configurar un mapa de usuarios simulado para devolver una contraseña simulada
        HashMap<String, String> users = new HashMap<>();
        users.put(username, password);
        userStorage = new HashMapUserStorage(users);

        assertEquals(password, userStorage.getPassword(username));
    }

    @Test
    void testGetPasswordNonExistentUser() {
        String nonExistentUsername = "usuario2";

        // Configurar un mapa de usuarios simulado sin el usuario buscado
        HashMap<String, String> users = new HashMap<>();
        userStorage = new HashMapUserStorage(users);

        assertNull(userStorage.getPassword(nonExistentUsername));
    }
}
