package co.kr.munjo.Repository.Utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends JpaRepository<T, Id> {

//    <E extends T> E save(@Nonnull T comment);

    boolean contains(T entity);

//    List<T> findAll();

//    long count();

//    @Nullable
//    <E extends T> Optional<E> findById(Id id);




}
