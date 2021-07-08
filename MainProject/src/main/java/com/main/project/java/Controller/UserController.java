package com.main.project.java.Controller;

import com.main.project.java.Entity.User;
import com.main.project.java.Repository.ProductRepository;
import com.main.project.java.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/user")
    public String userList(Model model) {
        List<User> userList =userRepository.findAll();
        model.addAttribute("userList", userList);
        return "user";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveUser( User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encodedPassword);
        userRepository.save(user);
        return "redirect:/mainMenu";
    }

    @GetMapping("/showUserFormForUpdate/{id}")
    public String showUserFormForUpdate(@PathVariable(value = "id") int userId, Model model) {
        User user = userRepository.findById(userId).get();
        model.addAttribute("user", user);
        return "updateUser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") int userId) {
        this.userRepository.deleteById(userId);
        return "redirect:/user";
    }


}