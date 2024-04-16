package pfe.rfc.crm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.IUserService;
import pfe.rfc.crm.repositories.UserRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    UserRepo userRepo;

    @Override
    public User CreateOrUpdateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
