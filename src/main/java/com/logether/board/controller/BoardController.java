package com.logether.board.controller;

import com.logether.board.domain.Board;
import com.logether.board.domain.BoardUpdate;
import com.logether.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/add")
    public ResponseEntity<String> boardAdd(@RequestBody Board board) {
        boardService.boardAdd(board);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> boardUpdate(@RequestBody BoardUpdate boardUpdate) {
        boolean isUpdated = boardService.boardUpdate(boardUpdate);
        return new ResponseEntity<>(isUpdated ? "true" : "false.", isUpdated ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}
