package pfe.rfc.crm.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.IUserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin
public class UserController {
    IUserService userService;
    @Operation(description = "récupérer toutes les utilisateurs de la base de données")
    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> listUsers = userService.retrieveAllUsers();
        return listUsers;
    }
    // http://localhost:8089/espritgather/user/retrieve-user/2
    @GetMapping("/retrieve-user/{user-id}")
    public User retrieveUser(@PathVariable("user-id") Long chId) {
        User user =userService.retrieveUser(chId);
        return user;
    }

    // Retrieve user by email
    @GetMapping("/retrieve-user-by-mail/{mail}")
    public User retrieveUserByEmail(@PathVariable("mail") String mail) {
        User user = userService.retrieveUserByMail(mail);
        return user;
    }


    // http://localhost:8089/espritgather/user/add-user
    @PostMapping("/users")
    public User adduser(@RequestBody User u) {
        User user = userService.addUser(u);
        return user;
    }
    // http://localhost:8089/espritgather/user/remove-user/{user-id}
    @DeleteMapping("/remove-user/{user-id}")
    public void removeUser(@PathVariable("user-id") Long chId) {
        userService.removeUser(chId);
    }

    // http://localhost:8089/espritgather/user/modify-user
    @PutMapping("/modify-user")
    public User modifyUser(@RequestBody User u) {
        User user = userService.modifyUser(u);
        return user;
    }
}
