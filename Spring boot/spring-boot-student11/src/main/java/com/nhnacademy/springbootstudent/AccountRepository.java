package com.nhnacademy.springbootstudent;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
}
