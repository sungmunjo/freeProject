package co.kr.munjo.Repository.custom;

import co.kr.munjo.Entity.Book;
import co.kr.munjo.Entity.Post;

import java.util.List;

public interface BookCustomRepository<T> {

    List<Book> findMyPost();

    void delete (T entity);

    List<Book> findByContainsTitle();
    

}
