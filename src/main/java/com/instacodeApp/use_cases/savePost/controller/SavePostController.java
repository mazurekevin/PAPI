package com.instacodeApp.use_cases.savePost.controller;

import com.instacodeApp.use_cases.post.exposition.PostDto;
import com.instacodeApp.use_cases.post.service.PostService;
import com.instacodeApp.use_cases.savePost.exposition.SavePostDto;
import com.instacodeApp.use_cases.savePost.service.SavePostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/SavePosts")
public class SavePostController {
    private SavePostService savePostService;

    public SavePostController(SavePostService savePostService) {
        this.savePostService = savePostService;
    }

    @PostMapping
    public ResponseEntity<SavePostDto> createSavePost(@Valid @RequestBody SavePostDto savePostDto) {
        return new ResponseEntity<>(this.savePostService.createSavePost(savePostDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavePostDto> getSavePostById(@PathVariable(name = "id") long postId){
        return new ResponseEntity<>(this.savePostService.getSavePostById(postId),HttpStatus.OK);}

    @GetMapping("/user/{myPseudo}")
    public List<SavePostDto> getSavePostsByName(@PathVariable(name="myPseudo") String MyPseudo){
        List<SavePostDto> result = this.savePostService.findSavePostByMyPseudo(MyPseudo);
        Collections.reverse(result);
        return result;
    }

    @GetMapping
    public List<SavePostDto> getAllSavePosts(){
        List<SavePostDto> result = this.savePostService.getAllSavePosts();
        Collections.reverse(result);
        return result;
    }



    @DeleteMapping("/{id}")
    public void deleteSavePostById(@PathVariable(name = "id") long postId){
        this.savePostService.deleteSavePostById(postId);
    }
}
