package pfe.rfc.crm.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.entities.LikePost;
import pfe.rfc.crm.entities.Post;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.services.LikeService;
import pfe.rfc.crm.services.PostService;
import pfe.rfc.crm.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/likes")
@AllArgsConstructor
@CrossOrigin("*")
public class LikeController {
    private LikeService likeService;
    private final UserService userService;
    private final PostService postService;



    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
    }

    @GetMapping("/{id}")
    public LikePost getLikeById(@PathVariable Long id) {
        return likeService.getLikeById(id);
    }

    @GetMapping
    public List<LikePost> getAllLikes() {
        return likeService.getAllLikes();
    }

    @PostMapping
    public LikePost createLikePost(@RequestParam Long postId, @RequestParam Long userId) {
        User user = userService.getUserById(userId);
        Post post = postService.getPostById(postId);

        LikePost likePost = new LikePost();
        likePost.setUser(user);
        likePost.setPost(post);

        return likeService.saveLike(likePost);
    }
}
