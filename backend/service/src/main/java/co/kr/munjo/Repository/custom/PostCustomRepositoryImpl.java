package co.kr.munjo.Repository.custom;


import co.kr.munjo.Entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PostCustomRepositoryImpl implements PostCustomRepository<Post> {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Post> findMyPost(){
        return entityManager.createQuery("SELECT P FROM Post P", Post.class).getResultList();
    }

    @Override
    public void delete(Post entity) {
        System.out.println("entity delete");
        entityManager.remove(entity);
    }
}
