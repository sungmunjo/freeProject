package co.kr.munjo.Repository;

import co.kr.munjo.Entity.Comment;
import co.kr.munjo.Entity.Post;
import co.kr.munjo.Repository.Utils.MyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CommentRepository extends MyRepository<Comment, Long> {


    List<Comment> findByCommentContextContains(String commentContext);

    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

    Page<Comment> findByCommentContextContainsAndLikeCountGreaterThan(String commentContext, int likeCount, Pageable pageable );

}
