package fr.yncrea.cin3.chessgame;

import fr.yncrea.cin3.chessgame.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {

    private User u;

    @BeforeEach
    public void before() {
        u = new User();
    }

    @Test
    public void gettersTest() {

        u.setId(2048L);
        u.setUsername("User");
        u.setEmail("user@test.com");
        u.setPassword("password");

        assertThat(u.getId()).isEqualTo(2048L);
        assertThat(u.getUsername()).isEqualTo("User");
        assertThat(u.getEmail()).isEqualTo("user@test.com");
        assertThat(u.getPassword()).isEqualTo("password");
    }

    @Test
    public void isAccountNonExpiredTest() {
        assertThat(u.isAccountNonExpired()).isTrue();
    }

    @Test
    public void isAccountNonLockedTest() {
        assertThat(u.isAccountNonLocked()).isTrue();
    }

    @Test
    public void isCredentialsNonExpiredTest() {
        assertThat(u.isCredentialsNonExpired()).isTrue();
    }

    @Test
    public void isEnabledTest() {
        assertThat(u.isEnabled()).isTrue();
    }
}
