package by.tut.ssmt.dao;

import by.tut.ssmt.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserData {

    private static UserData instance = new UserData();

    private List<User> users;

    public static UserData getInstance() {
        return instance;
    }

    private UserData () {
        users = new ArrayList<>();
    }

    public void add(User user) {
        users.add(user);
    }

    public List<String> listUsers() {
        return (List<String>) users.stream();
    }

    public List<String> listNames() {
                return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public List<String> listPasswords() {
                return users.stream()
                .map(User::getPassword)
                .collect(Collectors.toList());
    }


}
