package com.example.web.domain.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("temp")
    public String temp() {
        return "temp";
    }

    @GetMapping("temp2")
    public String temp2() {
        return "temp2";
    }
}
