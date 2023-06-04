package com.nhnacademy.board_remind.service;

import com.nhnacademy.board_remind.domain.Users;
import com.nhnacademy.board_remind.exception.ExistUserException;
import com.nhnacademy.board_remind.exception.NotFoundStudentException;
import com.nhnacademy.board_remind.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<Users> getUsers(){
        return userRepository.getUsers();
    }

    public Users getUser(String id){
        Users user =userRepository.getUser(id);
        if(Objects.isNull(user)){
            throw new NotFoundStudentException(id);
        }
        return user;
    }

    public void delete(String id){
        userRepository.remove(id);
    }

    public void register(Users user){
        if(userRepository.existById(user.getId())){
            throw new ExistUserException(user.getId());
        }
        userRepository.add(user);
    }

    public void modify(Users user){
        userRepository.modify(user);
    }
    public List<Users> getPartList(int num){
        num = (num-1)*10;
        int size = 10;
        List<Users> userList = new ArrayList<>();
        List<Users> list = userRepository.getUsers();
        if(list.size()<num+10){
            size=list.size()-num;
        }
        for(int i=0;i<10;i++){
            userList.add(list.get(num));
            num++;
        }
        return userList;
    }

}
