package fr.yncrea.cin3.chessgame.service;

import fr.yncrea.cin3.chessgame.domain.user.User;
import fr.yncrea.cin3.chessgame.form.UserForm;
import fr.yncrea.cin3.chessgame.repositories.AuthorityRepository;
import fr.yncrea.cin3.chessgame.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DbUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository users;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository roleRepository;

    public UserForm createForm(User user) {
        UserForm form = new UserForm();
        if (user == null) {
            return form;
        }
        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setUsername(user.getUsername());
        return form;
    }
    public void save(UserForm userForm) {
        User user = new User();
        user.setId(userForm.getId());
        user.setUsername(userForm.getUsername());
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setAuthorities(Collections.singletonList(roleRepository.findByAuthority("ROLE_USER")));
        users.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user = users.findByEmail(email);
        if(user == null)
            throw new UsernameNotFoundException(email);
        return user;
    }

}
