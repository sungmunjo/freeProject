package co.kr.munjo;


import co.kr.munjo.Entity.Post;
import co.kr.munjo.Repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CrudRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void crudRepository() {
        Post insertPost = new Post();
        insertPost.setTitle("testTitle1122");
        assertThat(insertPost.getId()).isNull();

        //when
        postRepository.save(insertPost);

        //then
        assertThat(insertPost.getId()).isNotNull();


        //when
        List<Post> posts = postRepository.findAll();

        //then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(insertPost);


        //when
        Page<Post> posts1 = postRepository.findAll(PageRequest.of(0,10));
        assertThat(posts1.getSize()).isEqualTo(10);


        Page<Post> test = postRepository.findByTitleContains("Title1122", PageRequest.of(0, 10));
        assertThat(test.getTotalElements()).isEqualTo(1);
        assertThat(test.getNumber()).isEqualTo(0);
        assertThat(test.getSize()).isEqualTo(10);
        assertThat(test.getNumberOfElements()).isEqualTo(1);

        Post nextPost = new Post();
        nextPost.setTitle("test222");
        postRepository.save(nextPost);
//        Comment comment1 = new Comment();
//        comment1.setCommentContext("testComment1");
//        Comment comment2 = new Comment();
//        comment2.setCommentContext("testComment2");
//
//        insertPost.getComments().add(comment1);
//        insertPost.getComments().add(comment2);
//
//
//        Post post = postRepository.getReferenceById(insertPost.getId());


    }


}
