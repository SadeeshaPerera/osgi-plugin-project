package com.mtit.osgi.userproducer;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private Map<String, String> users = new HashMap<>();

    @Override
    public void registerUser(String username, String email) {
        users.put(username, email);
        System.out.println("User registered: " + username + " - " + email);
    }

    @Override
    public void updateUser(String username, String email) {
        if (users.containsKey(username)) {
            users.put(username, email);
            System.out.println("User updated: " + username + " - " + email);
        } else {
            System.out.println("User not found: " + username);
        }
    }

    @Override
    public void deleteUser(String username) {
        if (users.containsKey(username)) {
            users.remove(username);
            System.out.println("User deleted: " + username);
        } else {
            System.out.println("User not found: " + username);
        }
    }

    @Override
    public String getUserDetails(String username) {
        return users.getOrDefault(username, "User not found");
    }
}