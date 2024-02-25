package co.kr.munjo.Repository;

import co.kr.munjo.Entity.Comment;
import co.kr.munjo.Entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void getComment(){
        Post post = new Post();
        post.setTitle("jpa");
        postRepository.save(post);

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUp(10);
        comment.setDown(1);

        commentRepository.save(comment);


        commentRepository.findByPost_id(post.getId()).forEach(c->{
            System.out.println(c.getVotes());
        });
    }

}