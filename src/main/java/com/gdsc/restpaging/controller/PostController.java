package com.gdsc.restpaging.controller;


import com.gdsc.restpaging.domain.PageCustomize;
import com.gdsc.restpaging.dto.PostDTO;
import com.gdsc.restpaging.dto.PostPagingDto;
import com.gdsc.restpaging.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public void save (@RequestBody PostDTO postDTO){
        postService.save(postDTO);
    }

    @GetMapping
    public PageCustomize findAll(@RequestBody PostPagingDto postPagingDto){
        return postService.findAllPosts(postPagingDto);
    }
}
