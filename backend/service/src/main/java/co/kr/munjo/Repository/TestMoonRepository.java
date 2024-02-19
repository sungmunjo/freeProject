package co.kr.munjo.Repository;

import co.kr.munjo.Entity.TestMoon;
import co.kr.munjo.Repository.Utils.MyRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TestMoonRepository extends MyRepository<TestMoon, Long> , QuerydslPredicateExecutor<TestMoon> , SimpleJpaRepository<TestMoon, Long> {

}
