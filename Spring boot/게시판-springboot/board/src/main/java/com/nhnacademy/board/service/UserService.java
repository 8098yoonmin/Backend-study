package com.nhnacademy.board.service;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.exception.StudentNotFoundException;
import com.nhnacademy.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

//    private final PropertiesConfig propertiesConfig;

    public User getUser(String id){
        User user =  userRepository.findById(id).orElse(null);
        if(Objects.isNull(user)){
            throw new StudentNotFoundException(id);
        }
        return user;
    }
    public void delete(String id){
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public Page getUserList(Pageable pageable){
        Page page = userRepository.getAllBy(pageable);
        return page;

    }

    public void register(User user){
        userRepository.save(user);
    }


    public void modify(User user){
        userRepository.save(user);
    }

    public String getProfileImagePath(String id) {
        User user = getUser(id);
        if (Objects.nonNull(user)) {
            if(StringUtils.hasText(user.getProfileFileName())){
                return user.getProfileFileName();
            }
        }
        return "no-image.png";
    }

    public Page paging(Pageable pageable){
        return userRepository.getUsersBy(pageable);
    }

}
