package com.example.web.domain.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    public int createMember(Member member);

    public Optional<Member> findMemberById(String id);

    public Optional<Member> findMemberByEmail(String email);

    public int updateMember(Member member);

    public int deleteMember(String id);

    public Optional<List<Member>> findAllMember();

}
