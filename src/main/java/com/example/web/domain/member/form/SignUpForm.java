package com.example.web.domain.member.form;

import com.example.web.domain.member.enums.Gender;
import com.example.web.domain.member.enums.Hobby;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * 회원가입 폼
 */
@Data
public class SignUpForm {
    @NotEmpty
    private String id;

    @NotEmpty
    private String password;

    @Email @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    @NotEmpty
    private Gender gender;

    @NotEmpty
    private String phone;

    private Hobby hobby;
}
