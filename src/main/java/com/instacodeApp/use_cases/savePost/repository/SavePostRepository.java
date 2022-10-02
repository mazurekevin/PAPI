package com.instacodeApp.use_cases.savePost.repository;

import com.instacodeApp.use_cases.post.domain.Post;
import com.instacodeApp.use_cases.savePost.domain.SavePost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavePostRepository extends JpaRepository<SavePost,Long> {

    List<SavePost> findSavePostByMyPseudo(String MyPseudo);

}
