package pfe.rfc.crm.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.entities.Comment;
import pfe.rfc.crm.entities.Post;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.services.CommentService;
import pfe.rfc.crm.services.PostService;
import pfe.rfc.crm.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
@CrossOrigin
public class CommentController {

    private CommentService commentService;
    private final UserService userService;
    private final PostService postService;


    /*@PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }
*/

    @PostMapping
    public Comment createComment(@RequestParam Long postId, @RequestParam Long userId, @RequestBody Comment comment) {
        User user = userService.getUserById(userId);
        Post post = postService.getPostById(postId);

        comment.setUser(user);
        comment.setPost(post);

        return commentService.saveComment(comment);
    }
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }
}
