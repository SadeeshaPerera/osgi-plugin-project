package com.mtit.osgi.userproducer;

public interface UserService {
    void registerUser(String username, String email);
    void updateUser(String username, String email);
    void deleteUser(String username);
    String getUserDetails(String username);
}