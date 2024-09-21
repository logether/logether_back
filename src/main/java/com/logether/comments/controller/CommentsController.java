package com.logether.comments.controller;

import com.logether.comments.domain.Comments;
import com.logether.comments.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @PostMapping("/commentsAdminAdd")
    public ResponseEntity<String> CommentsAdminAdd(@RequestBody Comments comments) {
        commentsService.CommentsAdminAdd(comments);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

}
