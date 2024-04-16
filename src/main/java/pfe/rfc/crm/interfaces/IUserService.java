package pfe.rfc.crm.interfaces;

import pfe.rfc.crm.entities.User;

import java.util.List;

public interface IUserService {


    User CreateOrUpdateUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);
}
