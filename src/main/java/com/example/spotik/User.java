package com.example.spotik;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
    private String password;
    private int age;
    private SexType sex;
    private String email;
}

enum SexType{
    male,
    female,
    other
}