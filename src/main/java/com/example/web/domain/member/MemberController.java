package com.example.web.domain.member;

import com.example.web.domain.member.form.LoginForm;
import com.example.web.domain.member.form.SignUpForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final ModelMapper modelMapper;
    private final MemberService memberService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "member/login";
    }

    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "member/signup";
    }

    @PostMapping("/login")
    public String loginProcess(@ModelAttribute @Valid LoginForm loginForm) {
        log.info("{}", loginForm);

        return "member/login";
    }

    @PostMapping("/signup")
    public String signUpProcess(@ModelAttribute @Valid SignUpForm signUpForm) {
        Member member = modelMapper.map(signUpForm, Member.class);
        memberService.createMember(member);
        return "member/login";
    }
}
