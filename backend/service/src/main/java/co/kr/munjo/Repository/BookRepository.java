package co.kr.munjo.Repository;

import co.kr.munjo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BookRepository  extends JpaRepository<Book, Long>, QuerydslPredicateExecutor<Book> {

    
}
