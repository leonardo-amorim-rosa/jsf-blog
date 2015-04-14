package br.com.estudo.jsf22.services;

import br.com.estudo.jsf22.entities.Post;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PostService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void create(Post post) {
        entityManager.persist(post);
    }
    
    public void update(Post post) {
        if (post != null && post.getId() != null)
            entityManager.merge(post);
    }
    
    public void remove(long id) {        
        entityManager.remove(getById(id));
    }
    
    public Post getById(long id) {
        return entityManager.find(Post.class, id);
    }
    
    public List<Post> getAll() {
        return entityManager.createNamedQuery("from Post").getResultList();
    }
}
