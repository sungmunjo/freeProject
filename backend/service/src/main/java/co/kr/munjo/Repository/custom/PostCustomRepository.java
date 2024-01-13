package co.kr.munjo.Repository.custom;

import co.kr.munjo.Entity.Post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findMyPost();

    void delete (T entity);

}
