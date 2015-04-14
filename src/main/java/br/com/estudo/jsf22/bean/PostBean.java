package br.com.estudo.jsf22.bean;

import br.com.estudo.jsf22.entities.Post;
import br.com.estudo.jsf22.services.PostService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PostBean {
    
    @EJB
    private PostService postService;
    private Post post;
    private List<Post> posts;
    
    public PostBean() {
    }

    public void create() {
        postService.create(post);
        resetPosts();
    }
    
    public void update() {
        if (post.getId() != null) {
            postService.getById(post.getId());
            resetPosts();
        }        
    }
    
    public void remove() {
        if (post.getId() != null) {
            postService.remove(post.getId());
            resetPosts();
        }
    }
    
    private void resetPosts() {
        posts = null;
        post = null;
    }
    
    public Post getPost() {
        if (post == null) {
            post = new Post();
        }
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Post> getPosts() {
        if (posts == null) {
            posts = postService.getAll();
        }
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
        
}
