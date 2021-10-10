package com.example.web.domain.member;

import com.example.web.global.security.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public int createMember(Member member) {
        member.setRole(Role.MEMBER);
        return memberMapper.createMember(member);
    }

    public List<Member> findAllMember() {
        return memberMapper.findAllMember()
                .orElseGet(() -> Collections.emptyList());
    }

    public Member findMemberById(String id) {
        return memberMapper.findMemberById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("id {%s} member not found ", id)));
    }

    public int updateMemberById(Member member) {
        return memberMapper.updateMember(member);
    }

    public int deleteMemberById(String id) {
        return memberMapper.deleteMember(id);
    }
}
