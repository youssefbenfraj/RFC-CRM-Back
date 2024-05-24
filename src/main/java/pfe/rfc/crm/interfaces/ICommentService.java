package pfe.rfc.crm.interfaces;

import pfe.rfc.crm.entities.Comment;
import pfe.rfc.crm.entities.Post;
import pfe.rfc.crm.entities.User;

import java.util.List;

public interface ICommentService  {

    Comment saveComment(Comment comment);

    void deleteComment(Long id);

    Comment getCommentById(Long id);

    List<Comment> getAllComments();

}
