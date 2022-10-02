package com.instacodeApp.use_cases.savePost.service;

import com.instacodeApp.use_cases.post.exposition.PostDto;
import com.instacodeApp.use_cases.savePost.exposition.SavePostDto;

import java.util.List;

public interface SavePostService {
    SavePostDto createSavePost(SavePostDto savePostDto);
    List<SavePostDto> getAllSavePosts();
    SavePostDto getSavePostById(long id);
    SavePostDto updateSavePost(SavePostDto savePostDto, long id);
    void deleteSavePostById(long id);
    List<SavePostDto> findSavePostByMyPseudo(String MyPseudo);
}
