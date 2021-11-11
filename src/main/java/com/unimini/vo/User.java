package com.unimini.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long userCode;
    private String userId;   //이메일
    private String password; //패스워드
    private String userAuth; //권한
}