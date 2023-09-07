package com.leonidfrolov.spring.pastebox.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PasteBoxEntity {
    private int id;
    private String data;
    private String hash;
    private LocalDateTime lifeTime;
    private boolean isPublic;
}
