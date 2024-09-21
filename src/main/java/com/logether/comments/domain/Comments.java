package com.logether.comments.domain;

import lombok.Data;

@Data
public class Comments {
    private int comtsCode;
    private int boardCode;
    private String userId;
    private String comtsContents;
}
