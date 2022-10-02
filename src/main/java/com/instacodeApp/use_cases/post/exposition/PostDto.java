package com.instacodeApp.use_cases.post.exposition;

import com.instacodeApp.use_cases.comment.domain.Comment;
import com.instacodeApp.use_cases.comment.exposition.CommentDto;
import lombok.Data;

import javax.persistence.Column;
import java.util.Set;

@Data
public class PostDto {
    public Long id;
    public String name;
    public String caption;
    public String code;
    public String language;
    public int likeCount;
    public Long originId;
    public String originName;
    public Set<CommentDto> comments;

}
