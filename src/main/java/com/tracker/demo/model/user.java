package com.tracker.demo.model;

import lombok.Data;

@Data
public class user {

    private Long id;
    private String name;
    private String email;
    private String password;
}