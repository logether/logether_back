package com.logether.board.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Board {
    private int boardCode;
    private String boardBody;
    private Date boardDate;
    private String boardUserId;
}
