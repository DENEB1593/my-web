package com.example.web.domain.member;

import com.example.web.domain.member.form.LoginForm;
import com.example.web.domain.member.form.SignUpForm;
import com.example.web.domain.member.validator.LoginFormValidator;
import com.example.web.domain.member.validator.SignUpFormValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final ModelMapper modelMapper;
    private final MemberService memberService;
    private final SignUpFormValidator signUpFormValidator;
    private final LoginFormValidator loginFormValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(signUpFormValidator);
    }

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
    public String loginProcess(@ModelAttribute LoginForm loginForm) {
        log.info("{}", loginForm);

        return "member/login";
    }

    @PostMapping("/signup")
    public String signUpProcess(@ModelAttribute @Valid SignUpForm signUpForm, Errors errors) {
        if (errors.hasErrors()) {
            return "member/signup";
        }
        Member member = modelMapper.map(signUpForm, Member.class);
        memberService.createMember(member);
        return "redirect:/member/login";
    }
}
