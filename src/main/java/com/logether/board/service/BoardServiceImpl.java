package com.logether.board.service;

import com.logether.board.domain.Board;
import com.logether.board.domain.BoardUpdate;
import com.logether.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public void boardAdd(Board board) {
        boardMapper.boardAdd(board);
    }

    @Override
    public Boolean boardUpdate(BoardUpdate boardUpdate) {
        boardMapper.boardUpdate(boardUpdate);
        return true;
    }

}
