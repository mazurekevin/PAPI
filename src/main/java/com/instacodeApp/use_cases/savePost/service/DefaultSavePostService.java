package com.instacodeApp.use_cases.savePost.service;

import com.instacodeApp.use_cases.follow.domain.Follow;
import com.instacodeApp.use_cases.post.domain.Post;
import com.instacodeApp.use_cases.post.exception.ResourceNotFoundException;
import com.instacodeApp.use_cases.post.exposition.PostDto;
import com.instacodeApp.use_cases.post.repository.PostRepository;
import com.instacodeApp.use_cases.savePost.domain.SavePost;
import com.instacodeApp.use_cases.savePost.exposition.SavePostDto;
import com.instacodeApp.use_cases.savePost.repository.SavePostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultSavePostService implements SavePostService{


    private final SavePostRepository savePostRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DefaultSavePostService(SavePostRepository savePostRepository,ModelMapper modelMapper) {
        this.savePostRepository = savePostRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public SavePostDto createSavePost(SavePostDto savePostDto) {
        SavePost savePost = mapToEntity(savePostDto);
        SavePost newSavePost = savePostRepository.save(savePost);
        return mapToDto(newSavePost);
    }

    @Override
    public List<SavePostDto> getAllSavePosts() {
        List<SavePost> savePosts = this.savePostRepository.findAll();
        return savePosts.stream().map(savePost -> mapToDto(savePost)).collect(Collectors.toList());    }

    @Override
    public SavePostDto getSavePostById(long id) {
        SavePost savePost = savePostRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(savePost);
    }

    @Override
    public SavePostDto updateSavePost(SavePostDto savePostDto, long id) {
        return null;
    }

    @Override
    public void deleteSavePostById(long id) {
        SavePost savePost = this.savePostRepository.findById(id).orElseThrow();
        this.savePostRepository.delete(savePost);
    }

    @Override
    public List<SavePostDto> findSavePostByMyPseudo(String MyPseudo) {
        List<SavePost> savePost = this.savePostRepository.findSavePostByMyPseudo(MyPseudo);
        return savePost.stream().map(save -> mapToDto(save)).collect(Collectors.toList());
    }


    private SavePostDto mapToDto(SavePost savePost){
        return modelMapper.map(savePost, SavePostDto.class);
    }

    private SavePost mapToEntity(SavePostDto savePostDto){
        return modelMapper.map(savePostDto, SavePost.class);
    }

}
