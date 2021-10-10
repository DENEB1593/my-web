package com.example.web.mapper;

import com.example.web.domain.member.Member;
import com.example.web.domain.member.MemberMapper;
import com.example.web.domain.member.enums.Gender;
import com.example.web.domain.member.enums.Hobby;
import com.example.web.global.security.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@Slf4j
@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @DisplayName("회원 가입 테스트")
    public void memberCreateTest() {
        Member member = new Member();
        member.setId("deneb1593");
        member.setEmail("deneb1593@gmail.com");
        member.setPassword("1234");
        member.setRole(Role.MEMBER);
        member.setGender(Gender.MALE);
        member.setPhone("010-1234-5456");
        member.setHobby(Hobby.GAME);

        memberMapper.createMember(member);
    }

    @Test
    @DisplayName("회원 조회")
    public void findMemberByIdTest() {
        String id = "leekangwoon1@naver.com";
        Optional<Member> member = memberMapper.findMemberById(id);
        member.ifPresent(m -> {
            log.info("{}", m);
        });
    }
}