package pfe.rfc.crm.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pfe.rfc.crm.entities.User;
import pfe.rfc.crm.interfaces.IUserService;

import java.util.List;

@RestController
@RequestMapping("/User")
@AllArgsConstructor
public class UserController {
    IUserService userService;

    @GetMapping("/getAllUsers")
    public List<User> retrieveAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.CreateOrUpdateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void removeUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/getUserById/{id}")
    public User retrieveUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
