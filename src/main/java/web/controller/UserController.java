package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/addUsers")
    public String addUser(@RequestParam String username, @RequestParam String email,
                          @RequestParam int age) {
        User user = new User(username, email, age);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam long id, @RequestParam String username,
                             @RequestParam String email, @RequestParam int age) {
        User user = new User(username, email, age);
        userService.updateUser(user);
        return "redirect:/users";
    }
}
