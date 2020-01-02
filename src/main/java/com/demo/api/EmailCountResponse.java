package com.demo.api;

import lombok.Getter;

import java.util.Map;

@Getter
public class EmailCountResponse {
    private Map<String, Integer> emailsCount;

    public EmailCountResponse(Map<String, Integer> map) {
        emailsCount = map;
    }
}
