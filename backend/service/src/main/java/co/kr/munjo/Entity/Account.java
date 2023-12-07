package co.kr.munjo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

}
