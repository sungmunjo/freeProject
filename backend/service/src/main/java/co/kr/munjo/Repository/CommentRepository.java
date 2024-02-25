package co.kr.munjo.Repository;

import co.kr.munjo.Entity.Comment;
import co.kr.munjo.Entity.Post;
import co.kr.munjo.Repository.Utils.MyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;


public interface CommentRepository extends MyRepository<Comment, Long>  {


    List<Comment> findByCommentContextContains(String commentContext);

    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

    Stream<Comment> findByCommentContextContainsAndLikeCountGreaterThan(String commentContext, int likeCount, Pageable pageable );

//    @Async
//    Future<List<Comment>> findByCommentContextContainsIgnoreCase(String keyword, Pageable pageable);

    @Async
    CompletableFuture<List<Comment>> findByCommentContextContainsIgnoreCase(String keyword, Pageable pageable);

    List<CommentSummary> findByPost_id(Long id);

}
