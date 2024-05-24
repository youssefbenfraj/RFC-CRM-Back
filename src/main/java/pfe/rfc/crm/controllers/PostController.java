package pfe.rfc.crm.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.entities.Comment;
import pfe.rfc.crm.entities.Post;
import pfe.rfc.crm.interfaces.IPostService;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/comments")
    public Map<Long, List<Comment>> getCommentsPerPost() {
        return postService.getCommentsPerPost();
    }

    @GetMapping("/posts/getLikesCount/{postId}")
    public int getLikesCountForPost(@PathVariable Long postId) {
        return postService.getLikesCountForPost(postId);
    }
}
