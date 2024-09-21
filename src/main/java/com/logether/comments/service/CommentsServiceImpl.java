package com.logether.comments.service;

import com.logether.comments.domain.Comments;
import com.logether.comments.mapper.CommentsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final CommentsMapper commentsMapper;

    @Override
    public void CommentsAdminAdd(Comments comments) {
        commentsMapper.CommentsAdminAdd(comments);
    }
}
