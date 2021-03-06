package fr.yncrea.cin3.chessgame;

import fr.yncrea.cin3.chessgame.domain.user.Authority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AuthorityTest {

    private Authority auth;

    @BeforeEach
    public void before() {
        auth = new Authority();
    }

    @Test
    public void gettersTest() {

        auth.setId(2048L);
        auth.setAuthority("username");

        assertThat(auth.getId()).isEqualTo(2048L);
        assertThat(auth.getAuthority()).isEqualTo("username");
    }
}
