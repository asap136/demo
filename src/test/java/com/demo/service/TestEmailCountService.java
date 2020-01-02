package com.demo.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestEmailCountService {

    @Test
    public void testInvalidEmails() {
        List<String> emails = Arrays.asList("me@.com my", "me@123.com.com", "me..2002@gmail.com");
        EmailCountService emailCountService = new EmailCountService();
        Map<String, Integer> mapCounts = emailCountService.emailCount(emails);
        assert(mapCounts.size() == 0);
    }

    @Test
    public void testCounts0() {
        List<String> emails = new ArrayList<>();
        EmailCountService emailCountService = new EmailCountService();
        Map<String, Integer> mapCounts = emailCountService.emailCount(emails);
        assert(mapCounts.size() == 0);
    }

    @Test
    public void testCounts1() {
        List<String> emails = Arrays.asList("test.email@gmail.com", "testemail@gmail.com", "test.email+spam@gmail.com");
        EmailCountService emailCountService = new EmailCountService();
        Map<String, Integer> mapCounts = emailCountService.emailCount(emails);
        assert(mapCounts.size() == 1);
        assert(mapCounts.get("testemail@gmail.com") == 1);
    }

    @Test
    public void testCounts2() {
        List<String> emails = Arrays.asList("test.email@gmail.com", "test.email@gmail.com", "test+email+spam@gmail.com", "anant@gmail.com", "anant+@gmail.com");
        EmailCountService emailCountService = new EmailCountService();
        Map<String, Integer> mapCounts = emailCountService.emailCount(emails);
        assert(mapCounts.size() == 3);
        assert(mapCounts.get("testemail@gmail.com") == 1);
        assert(mapCounts.get("test@gmail.com") == 1);
        assert(mapCounts.get("anant@gmail.com") == 1);
    }

    @Test
    public void testCounts3() {
        List<String> emails = Arrays.asList("abc@yahoo.com", "test.email@gmail.com", "testemail+spam@gmail.com", "abc@yahoo.com", "+anant@gmail.com", "@gmail.com");
        EmailCountService emailCountService = new EmailCountService();
        Map<String, Integer> mapCounts = emailCountService.emailCount(emails);
        assert(mapCounts.size() == 1);
        assert(mapCounts.get("testemail@gmail.com") == 1);
    }

    @Test
    public void testCounts4() {
        List<String> emails = Arrays.asList("test.email@gmail.com", "testemail+@gmail.com", "testemail.+@gmail.com", "te.st.emai.l@gmail.com");
        EmailCountService emailCountService = new EmailCountService();
        Map<String, Integer> mapCounts = emailCountService.emailCount(emails);
        assert(mapCounts.size() == 1);
        assert(mapCounts.get("testemail@gmail.com") == 1);
    }
}
