package Ejercicio2;

import java.util.Map;

public class HashMapUserStorage implements UserStorage {
    private final Map<String, String> users;

    public HashMapUserStorage(Map<String, String> users) {
        this.users = users;
    }

    @Override
    public String getPassword(String username) {
        return users.get(username);
    }
}

