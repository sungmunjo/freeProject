package co.kr.munjo.Repository;

import co.kr.munjo.Entity.Book;
import co.kr.munjo.Entity.QBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void crud(){
        Book book = new Book();
        book.setTitle("spring");
        book.setContent("data");
        bookRepository.save(book);

        assertThat(bookRepository.findAll().size()).isEqualTo(1);

        Optional<Book> ring = bookRepository.findOne(QBook.book.title.contains("ring"));

        assertTrue(ring.isPresent());
        Optional<Book> jpa = bookRepository.findOne(QBook.book.title.contains("jpa"));

        assertFalse(jpa.isPresent());


//        bookRepository.findOne(Qbook)


    }

}