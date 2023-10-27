package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.PostDto;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
//    @Autowired //final 빼기
    private PostService postService;
//    @Autowired, 세터 주입은 잘 하지 않음
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> viewAllPosts() {
        List<Post> allPosts = postService.getAllPosts();
        System.out.println(allPosts);
        return allPosts;
    }
    @PostMapping("/posts")
    public Post registPost(@RequestBody Post post) { //binding
        System.out.println("before : " + post);
        postService.setPost(post);
        System.out.println("after : " + post);
        return post;
    }
    @PutMapping("/posts/{postId}")
    public String updatePost(@PathVariable("postId") int postId, @RequestBody PostDto postDto) {
        System.out.println("before : " + postDto);
        postService.updatePost(postId, postDto);
        System.out.println("after : " + postDto);
        return "업데이트 완료";
    }
}