package com.miab.services;



import com.miab.model.User;

public interface UserService {
    class IllegalUsernameException extends RuntimeException {}
    
    class IncorrectEmailException extends RuntimeException {}
    
    User createUser(String username, String password, String name, String email) throws IllegalUsernameException, IncorrectEmailException ;
    
    User findUser(String username);
    
    void deleteUser(String username) throws IllegalUsernameException;
    
    boolean verifyUser(String username, String password);
    
    int returnAllUsers();
}
