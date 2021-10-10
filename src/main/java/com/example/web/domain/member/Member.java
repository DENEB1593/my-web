package com.example.web.domain.member;

import com.example.web.domain.member.enums.Gender;
import com.example.web.domain.member.enums.Hobby;
import com.example.web.global.entity.BaseEntity;
import com.example.web.global.security.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@ToString
public class Member extends BaseEntity {
    private Long memberNo;
    private String id;
    private String password;
    private String email;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String phone;
    private Hobby hobby;

    /* for spring security */
    private Role role;
}
