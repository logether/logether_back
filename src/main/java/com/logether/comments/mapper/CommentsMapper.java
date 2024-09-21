package com.logether.comments.mapper;

import com.logether.comments.domain.Comments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper {

    void CommentsAdminAdd(Comments comments);

}
