package Ejercicio2;

public class Authenticator {
    private final UserStorage userStorage;

    public Authenticator(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    // Método para verificar si un usuario y contraseña son válidos
    public boolean authenticate(String username, String password) {
        String storedPassword = userStorage.getPassword(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}

