package fr.yncrea.cin3.chessgame.repositories;

import fr.yncrea.cin3.chessgame.domain.user.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByAuthority(String name);
}
