package co.kr.munjo.Repository;


import co.kr.munjo.Entity.Post;
import co.kr.munjo.Repository.custom.PostCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository<Post> {

    Page<Post> findByTitleContains(String title, Pageable pageable);

    long countByTitleContains(String title);
}
