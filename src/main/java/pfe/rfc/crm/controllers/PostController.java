package pfe.rfc.crm.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.entities.Post;
import pfe.rfc.crm.interfaces.IPostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
@CrossOrigin
public class PostController {
    IPostService postService;

    @GetMapping("/getAllPosts")
    public List<Post> retrieveAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post) {
        return postService.createOrUpdatePost(post);
    }

    @DeleteMapping("/deletePost/{id}")
    public void removePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @GetMapping("/getPostById/{id}")
    public Post retrievePost(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    /////////////////////

    @PostMapping("/addPost/{userId}")
    public Post addPost(@RequestBody Post post, @PathVariable Long userId) {
        return postService.createPostForUser(post, userId);
    }

    @GetMapping("/getPostsByUser/{userId}")
    public List<Post> retrievePostsByUser(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }
}
