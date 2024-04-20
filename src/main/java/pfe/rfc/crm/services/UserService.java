package pfe.rfc.crm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.IUserService;
import pfe.rfc.crm.repositories.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public List<User> retrieveAllUsers() {
        return userRepo.findAll();
    }
    public User retrieveUser(Long userId) {
        return userRepo.findById(userId).get();
    }

    public User addUser(User u) {
        return userRepo.save(u);
    }
    public void removeUser(Long userId) {
        userRepo.deleteById(userId);
    }
    public User modifyUser(User user) {
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);

        return userRepo.save(user);
    }

    @Override
    public User retrieveUserByMail(String mail) {
        return userRepo.findBymail(mail).orElse(null);
    }
}
