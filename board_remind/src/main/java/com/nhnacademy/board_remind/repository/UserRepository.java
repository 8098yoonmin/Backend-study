package com.nhnacademy.board_remind.repository;

import com.nhnacademy.board_remind.domain.Users;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    Map<String, Users> userMap = new HashMap<>();
    public void add(Users user) {
        userMap.put(user.getId(),user);
    }

    public void register(Users user){ userMap.put(user.getId(),user);}
    public void modify(Users user){userMap.put(user.getId(),user);}
    public void remove(String id) {
        userMap.remove(id);
    }
    public Users getUser(String id) {
        return userMap.get(id);
    }
    public List<Users> getUsers() {
        return userMap.values().stream().collect(Collectors.toList());
    }
    public boolean existById(String id) {
        return userMap.containsKey(id);
    }




}
