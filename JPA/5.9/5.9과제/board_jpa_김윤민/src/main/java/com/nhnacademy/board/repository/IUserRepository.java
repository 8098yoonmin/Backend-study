package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.pagenation.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, String>{
}