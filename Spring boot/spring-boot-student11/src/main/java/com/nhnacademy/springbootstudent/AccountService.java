package com.nhnacademy.springbootstudent;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account createAccount(Account account);

    Account getAccount(Long id);

    void deleteAccount(Long id);
}
