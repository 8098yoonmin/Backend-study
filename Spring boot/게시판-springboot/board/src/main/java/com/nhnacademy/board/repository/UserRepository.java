package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(String id);
    Page<User> getAllBy(Pageable pageable);
    Page<User> getUsersBy(Pageable pageable);

}
