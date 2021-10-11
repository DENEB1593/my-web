package com.example.web.domain.member.validator;

import com.example.web.domain.member.Member;
import com.example.web.domain.member.MemberMapper;
import com.example.web.domain.member.form.SignUpForm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SignUpFormValidator implements Validator {

    private MemberMapper memberMapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return SignUpForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpForm signUpForm = (SignUpForm) target;

        Optional<Member> member = memberMapper.findMemberById(signUpForm.getId());
        member.ifPresent(m -> {
            errors.rejectValue("id", "invalid.id", new Object[] {signUpForm.getId()}, "id already exists");
        });

        member = memberMapper.findMemberByEmail(signUpForm.getEmail());
        member.ifPresent(m -> {
            errors.rejectValue("email", "invalid.email", new Object[] {signUpForm.getEmail()}, "email already exists");
        });
    }
}
