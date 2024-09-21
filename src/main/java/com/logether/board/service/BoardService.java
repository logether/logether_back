package com.logether.board.service;

import com.logether.board.domain.Board;
import com.logether.board.domain.BoardUpdate;

public interface BoardService {

    void boardAdd(Board board);

    Boolean boardUpdate(BoardUpdate boardUpdate);
}
