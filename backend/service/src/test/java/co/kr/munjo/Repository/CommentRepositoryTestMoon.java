package co.kr.munjo.Repository;

import co.kr.munjo.Entity.Comment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RunWith(SpringRunner.class)
@DataJpaTest
class CommentRepositoryTestMoon {
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() throws ExecutionException, InterruptedException {
        /**
         * 기본 repository 사용 예제
         */
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

        this.createComment(55,"spring data jpa");
        this.createComment(100,"hibernate spring");

        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC, "LikeCount"));

        /**
         * future 사용 예제
         */
//        Future<List<Comment>> future = commentRepository.findByCommentContextContainsIgnoreCase("Spring", pageRequest);
//        System.out.println("_____________________");
//        System.out.println("isDone?" + future.isDone());
//
//        List<Comment> comments = future.get();
//        comments.forEach(System.out::println);

        /**
         * ListenableFuture
         */


//        CompletableFuture<List<Comment>> future = commentRepository.findByCommentContextContainsIgnoreCase("Spring", pageRequest);
//        CompletableFuture<List<Comment>> future = commentRepository.findByCommentContextContainsIgnoreCase("Spring", pageRequest);
//        future.thenAccept(s ->{
//            s.forEach(System.out::println);
//        });
        CompletableFuture<List<Comment>> future = commentRepository.findByCommentContextContainsIgnoreCase("Spring", pageRequest);
        System.out.println("_____________________");
        System.out.println("isDone?" + future.isDone());
        future.whenComplete((result, ex) -> {
            if(ex == null){
                result.forEach(System.out::println);
            }else{
                ex.printStackTrace();
            }
        });

//        List<Comment> comments = future.get();
//        comments.forEach(System.out::println);


        /**
         * Stream 사용 예제
         */
//        try(Stream<Comment> comments = commentRepository.findByCommentContextContainsAndLikeCountGreaterThan("spring", 10, pageRequest)){
//            Comment comment = comments.findFirst().get();
//            assertThat(comment.getLikeCount()).isEqualTo(100);
//        }


/**
 * 그냥 list 사용 예제
 */
//        List<Comment> items = comments.getContent();
//        assertThat(items.get(0).getCommentContext()).isEqualTo("hibernate spring");
//        assertThat(comments.getNumberOfElements()).isEqualTo(2);

    }

    private void createComment(int likeCount, String comment){
        Comment newComment = new Comment();
        newComment.setLikeCount(likeCount);
        newComment.setCommentContext(comment);

        commentRepository.save(newComment);
    }

}