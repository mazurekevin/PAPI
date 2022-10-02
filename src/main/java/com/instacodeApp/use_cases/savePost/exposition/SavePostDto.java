package com.instacodeApp.use_cases.savePost.exposition;

import com.instacodeApp.use_cases.comment.domain.Comment;
import lombok.Data;
import java.util.Set;

@Data
public class SavePostDto {
    public Long savePostId;

    public String MyPseudo;

    public String name;

    public String caption;

    public String code;

    public String language;

    public int likeCount;

    public Long originId;

    public String originName;

}
