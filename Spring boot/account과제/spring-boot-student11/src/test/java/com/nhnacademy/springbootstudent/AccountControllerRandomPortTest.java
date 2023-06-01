package com.nhnacademy.springbootstudent;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class AccountControllerRandomPortTest {
    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    void testGetAccounts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Account> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Account>> exchange = testRestTemplate.exchange(
                "/accounts",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Account>>() {
                });

        assertThat(exchange.getBody())
                .contains(new Account(1L, "1234566677", 110000));
    }

    @Test
    void testGetAccount() {
        ResponseEntity<Account> result = testRestTemplate.getForEntity(
                "/accounts/{id}",
                Account.class,
                1L);

        assertThat(result.getBody())
                .isEqualTo(new Account(1L, "1234566677", 110000));
    }

    @Test
    @Order(3)
    void testCreateAccount() {
        Account zbum = new Account(4L, "zbum2", 1000);
        ResponseEntity<Account> result = testRestTemplate.postForEntity(
                "/accounts",
                zbum,
                Account.class);

        assertThat(result.getBody())
                .isEqualTo(zbum);
    }

    @Test
    void testDeleteAccount() {
        testRestTemplate.delete(
                "/accounts/{id}",
                3L);
    }
}