package fr.yncrea.cin3.chessgame.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserForm {
    private Long id;

    @Size(min = 6, max=20)
    @NotEmpty
    private String username;

    @Email
    @NotEmpty
    private String email;

    @Size(min = 6, max=20)
    @NotEmpty
    private String password;
}
