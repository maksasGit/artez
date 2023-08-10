package com.example.spotik;

import lombok.*;

@Data
public class UserDTO {
    private Long id;
    private String nickname;
    private int age;
    private SexType sex;
}
