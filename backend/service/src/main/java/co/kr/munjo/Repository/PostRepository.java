package co.kr.munjo.Repository;


import co.kr.munjo.Entity.Post;
import co.kr.munjo.Repository.custom.PostCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository<Post>, QuerydslPredicateExecutor<Post> {

    Page<Post> findByTitleContains(String title, Pageable pageable);

    long countByTitleContains(String title);

    @Query("SELECT p FROM Post AS p WHERE p.title = ?1")
    List<Post> findByTitle(String title);

    //projection
    // open - 일단 가져와서 조합
    // closed -


}
