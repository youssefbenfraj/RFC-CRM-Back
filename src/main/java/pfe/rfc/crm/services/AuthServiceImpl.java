package pfe.rfc.crm.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.interfaces.IAuthService;
import pfe.rfc.crm.dto.SignupRequest;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.repositories.UserRepo;

import java.io.IOException;


@Service
public class AuthServiceImpl implements IAuthService {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AuthServiceImpl(UserRepo userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createUser(SignupRequest signupRequest) throws IOException {


        //Check if User exists

        User user = new User();
        //hedhi fi blasset el user.setmail(signurequest.getmail())
        BeanUtils.copyProperties(signupRequest,user);
        //

        // hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        User createdUser = userRepository.save(user);
        // UserRepository.save(user);


        return true;


    }


}