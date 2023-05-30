package com.nhnacademy.springbootstudent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultAccountService implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return  accountRepository.findAll();
    }
}
