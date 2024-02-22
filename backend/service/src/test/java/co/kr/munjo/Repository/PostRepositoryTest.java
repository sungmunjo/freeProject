package co.kr.munjo.Repository;

import co.kr.munjo.Entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

//import static com.mysema.commons.lang.Assert.assertThat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void save(){
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post); //persist

        assertThat(entityManager.contains(post)).isTrue();
        assertThat(entityManager.contains(savedPost)).isTrue();
        assertThat(savedPost == post);

        Post postUpdate = new Post();
        postUpdate.setId(post.getId());
        postUpdate.setTitle("hibernate");
        Post updatedPost = postRepository.save(postUpdate); //merge

        assertThat(entityManager.contains(updatedPost)).isTrue();
        assertThat(entityManager.contains(postUpdate)).isFalse();
        assertThat(updatedPost == postUpdate);


        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);


    }

}