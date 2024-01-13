package co.kr.munjo.Repository.custom;


import co.kr.munjo.Entity.QTestMoon;
import co.kr.munjo.Entity.TestMoon;
import co.kr.munjo.Repository.TestMoonRepository;
import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
class TestCustomRepositoryTestMoon {
    @Autowired
    TestMoonRepository testMoonRepository;



    @Test
    public void crud(){
        TestMoon test = new TestMoon();
        test.setIntroduction("hello?");
        test.setTitle("성문조");
        testMoonRepository.save(test);

        Predicate predicate = QTestMoon.testMoon.title.containsIgnoreCase("성");
        Optional<TestMoon> one = testMoonRepository.findOne(predicate);
        assertThat(one).isNotEmpty();


    }


}