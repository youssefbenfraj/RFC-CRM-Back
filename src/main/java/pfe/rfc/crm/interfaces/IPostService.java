package pfe.rfc.crm.interfaces;

import pfe.rfc.crm.entities.Comment;
import pfe.rfc.crm.entities.Post;

import java.util.List;
import java.util.Map;

public interface IPostService {
    Post createOrUpdatePost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long id);

    void deletePost(Long id);

    Post createPostForUser(Post post, Long userId);

    List<Post> getPostsByUserId(Long userId);

    Map<Long, List<Comment>> getCommentsPerPost();

    int getLikesCountForPost(Long postId);
}
