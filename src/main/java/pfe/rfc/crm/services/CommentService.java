package pfe.rfc.crm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.Comment;
import pfe.rfc.crm.entities.Post;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.ICommentService;
import pfe.rfc.crm.repositories.CommentRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService implements ICommentService {
    private final CommentRepo commentRepo;



    @Override
    public Comment saveComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }
}
