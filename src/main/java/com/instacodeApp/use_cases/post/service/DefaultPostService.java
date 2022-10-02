package com.instacodeApp.use_cases.post.service;

import com.instacodeApp.use_cases.post.domain.Post;
import com.instacodeApp.use_cases.post.exception.ResourceNotFoundException;
import com.instacodeApp.use_cases.post.exposition.PostDto;
import com.instacodeApp.use_cases.post.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultPostService implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DefaultPostService(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public PostDto createPost(PostDto postDto) {
        postDto.originId = postDto.id;
        postDto.originName = postDto.name;
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);
        return mapToDto(newPost);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = this.postRepository.findAll();
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.getById(id);
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setCaption(postDto.getCaption());
        post.setCode(postDto.getCode());
        post.setLanguage(postDto.getLanguage());
        post.setLikeCount(postDto.getLikeCount());

        Post updatedPost = postRepository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getPostsByName(String username) {
        List<Post> posts = this.postRepository.findPostsByName(username);
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    private PostDto mapToDto(Post post){
        return modelMapper.map(post, PostDto.class);
    }

    private Post mapToEntity(PostDto postDto){
        return modelMapper.map(postDto, Post.class);
    }

}
