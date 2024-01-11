package co.kr.munjo.Repository.Utils;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {

    <E extends T> E save(@Nonnull T comment);

    List<T> findAll();

    long count();

    @Nullable
    <E extends T> Optional<E> findById(Id id);


}
