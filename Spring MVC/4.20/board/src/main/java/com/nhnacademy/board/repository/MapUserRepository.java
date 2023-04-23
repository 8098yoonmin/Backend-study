package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MapUserRepository implements UserRepository {
    private Map<String, User> usersMap = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        usersMap.put(user.getUserId(),user);
    }

    @Override
    public void update(User user) {
        usersMap.put(user.getUserId(), user);
    }

    @Override
    public void deleteById(String id) {
        usersMap.remove(id);
    }

    @Override
    public User getUserById(String id) {
        return usersMap.get(id);
    }

    @Override
    public List<User> getUsers() {
        return usersMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean existById(String id) {
        return usersMap.containsKey(id);
    }

}
