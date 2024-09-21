package com.logether.board.mapper;

import com.logether.board.domain.Board;
import com.logether.board.domain.BoardUpdate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    void boardAdd(Board board);

    void boardUpdate(BoardUpdate boardUpdate);

}
