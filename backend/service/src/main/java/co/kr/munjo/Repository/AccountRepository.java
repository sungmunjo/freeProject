package co.kr.munjo.Repository;

import co.kr.munjo.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account,Long> {


}
