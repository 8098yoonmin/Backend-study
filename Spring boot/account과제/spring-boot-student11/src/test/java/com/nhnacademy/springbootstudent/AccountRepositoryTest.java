package com.nhnacademy.springbootstudent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

    @Test
    void testFindAll() throws Exception{
        Account 윤민 = new Account(10L, "윤민",10000);
        entityManager.merge(윤민);

        List<Account> actual = accountRepository.findAll();
        assertThat(actual.contains(윤민)).isEqualTo(true);
    }

    @Test
    void testFindById() throws Exception{
        Account 김윤민 = new Account(98L, "김윤민",1000);
        this.entityManager.merge(김윤민);

        Account actual = accountRepository.findById(98L).orElse(null);
        assertThat(actual).isEqualTo(김윤민);
    }
}