package Ejercicio2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

class HashMapUserStorageTest {
    private HashMapUserStorage hashMapUserStorage;
    private Map<String, String> mockUsers;

    @BeforeEach
    void setUp() {
        // Crear un mock para el mapa de usuarios
        mockUsers = mock(Map.class);
        hashMapUserStorage = new HashMapUserStorage(mockUsers);
    }

    @Test
    void testGetPassword() {
        // Configurar el comportamiento del mock para devolver una contraseña simulada cuando se llama a get()
        String username = "usuario1";
        String password = "password1";
        when(mockUsers.get(username)).thenReturn(password);

        // Ejecutar el método getPassword() y comprobar si devuelve la contraseña correcta
        assertEquals(password, hashMapUserStorage.getPassword(username));
    }

    @Test
    void testGetPasswordNonExistentUser() {
        // Configurar el comportamiento del mock para devolver null cuando se llama a get() con un usuario inexistente
        String nonExistentUsername = "usuario2";
        when(mockUsers.get(nonExistentUsername)).thenReturn(null);

        // Ejecutar el método getPassword() y comprobar si devuelve null para un usuario inexistente
        assertNull(hashMapUserStorage.getPassword(nonExistentUsername));
    }
}
