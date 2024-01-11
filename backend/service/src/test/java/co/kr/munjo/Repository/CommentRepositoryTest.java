package co.kr.munjo.Repository;

import co.kr.munjo.Entity.Comment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud(){
//        Comment comment = new Comment();
//        comment.setCommentContext("Hello Comment");
//        commentRepository.save(comment);
//
//        List<Comment> all = commentRepository.findAll();
//        assertThat(all.size()).isEqualTo(1);
//
//        long count = commentRepository.count();
//        assertThat(count).isEqualTo(1L);
//
//        Optional<Comment> byId = commentRepository.findById(100L);
//        assertThat(byId).isEmpty();
//        Comment comment1 = byId.orElse(new Comment());

        this.createComment(100,"spring data jpa");
        this.createComment(55,"hibernate spring");

        Page<Comment> comments = commentRepository.findByCommentContextContainsAndLikeCountGreaterThan("spring", 10, PageRequest.of(0,10));

        assertThat(comments.getNumberOfElements()).isEqualTo(2);

    }

    private void createComment(int likeCount, String comment){
        Comment newComment = new Comment();
        newComment.setLikeCount(likeCount);
        newComment.setCommentContext(comment);

        commentRepository.save(newComment);
    }

}