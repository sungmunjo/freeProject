package co.kr.munjo.Repository.custom;

import co.kr.munjo.Entity.Post;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findMyPost();

    void delete (T entity);


}
