package pfe.rfc.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.repositories.UserRepo;


import java.util.Collections;

@Service
public class LoginServiceImpl implements UserDetailsService {
    private final UserRepo userRepository ;

    @Autowired
    public LoginServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userRepository.findBymail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found" + mail));
        return new org.springframework.security.core.userdetails.User(user.getMail(), user.getPassword(), Collections.emptyList());


    }
}