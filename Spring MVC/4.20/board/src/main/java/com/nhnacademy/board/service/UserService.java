package com.nhnacademy.board.service;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    public User getUser(String id) {
        User user = userRepository.getUserById(id);
//        if(Objects.isNull(user)){
//            throw new UserNotFoundException;
//        }
        return user;
    }

    public List<User> getUserList(){
        return userRepository.getUsers();
    }

    public void delete(String id) { userRepository.deleteById(id);}

}
