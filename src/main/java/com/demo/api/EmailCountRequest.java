package com.demo.api;

import lombok.Getter;

import java.util.List;

@Getter
public class EmailCountRequest {
    private List<String> emails;
}
