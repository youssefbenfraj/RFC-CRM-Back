package pfe.rfc.crm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.Post;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.IPostService;
import pfe.rfc.crm.repositories.PostRepo;
import pfe.rfc.crm.repositories.UserRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static pfe.rfc.crm.entities.Status.PENDING;

@Service
@AllArgsConstructor
public class PostService implements IPostService {
    PostRepo postRepo;
    UserRepo userRepo;

    @Override
    public Post createOrUpdatePost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    /////////////////////////////
    @Override
    public Post createPostForUser(Post post, Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        post.setUser(user);
        post.setStatus(PENDING);
        return postRepo.save(post);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        return postRepo.findByUser(user);
    }
}
