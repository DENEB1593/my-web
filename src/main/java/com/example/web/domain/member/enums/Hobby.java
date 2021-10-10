package com.example.web.domain.member.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Hobby {
    GAME("01", "Game"),
    DRIVING("02", "Driving"),
    STUDY("03", "Study");

    private final String code;
    private final String text;
}
