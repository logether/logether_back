package com.logether.board.domain;

import lombok.Data;

@Data
public class BoardUpdate {
    private int boardCode;
    private String boardBody;
    private String boardUserId;
}
