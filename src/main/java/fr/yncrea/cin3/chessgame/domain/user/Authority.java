package fr.yncrea.cin3.chessgame.domain.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Authority  implements GrantedAuthority {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_seq_gen")
    @SequenceGenerator(name = "authority_seq_gen", sequenceName = "authority_id_seq")
    private Long id;

    private String authority;
}
