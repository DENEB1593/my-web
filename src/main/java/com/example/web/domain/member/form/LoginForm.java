package com.example.web.domain.member.form;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * 로그인 폼
 */
@Data
public class LoginForm {
    @NotEmpty
    private String id;
    
    @NotEmpty
    private String password;
}
