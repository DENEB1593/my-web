package com.example.web.global.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseEntity {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String deleteYn;
}
