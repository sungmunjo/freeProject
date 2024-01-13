package co.kr.munjo.Repository;

import co.kr.munjo.Entity.Post;
import co.kr.munjo.event.PostPublishedEvent;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
class PostRepositoryTestMoon {

    @Autowired
    PostRepository postRepository;
    @Autowired
    ApplicationContext applicationContext;

    @Test
    @Rollback(false)
    public void crud(){
        postRepository.findMyPost();
        Post post = new Post();
        post.setTitle("hibernate");
        postRepository.save(post.publish());

        postRepository.findMyPost();

        postRepository.delete(post);
    }



    @Test
    public void event(){
        Post post = new Post();
        post.setTitle("event");

        PostPublishedEvent postPublishedEvent = new PostPublishedEvent(post);

        applicationContext.publishEvent(postPublishedEvent);
    }

}