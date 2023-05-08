package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.User;

public interface UserRepository {
    boolean exists(String id);
    boolean matches(String id, String password, int age);

    User getUser(String id);

    boolean addUser(String id, String password, int age);

    boolean modifyUser(String id, String password, int age);

}
