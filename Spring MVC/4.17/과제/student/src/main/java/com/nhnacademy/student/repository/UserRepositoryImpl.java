package com.nhnacademy.student.repository;

import com.nhnacademy.student.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository{
    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public boolean exists(String id) {
        return userMap.containsKey(id);
    }

    @Override
    public boolean matches(String id, String password) {
        return Optional.ofNullable(getUser(id))
                .map(user -> user.getUserPassword().equals(password))
                .orElse(false);
    }

    @Override
    public User getUser(String id) {
        return exists(id) ? userMap.get(id) : null;
    }
    @Override
    public User addUser(String id, String password) {
//        if (exists(id)) {
//            throw new UserAlreadyExistsException();
//        }
        User user = new User(id, "admin", password);
        userMap.put(id, user);
        return user;

    }

}
