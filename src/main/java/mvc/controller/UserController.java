package mvc.controller;

import mvc.dao.UserDao;
import mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String printWelcome(Model model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("Welcome to my first Spring MVC application!");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/allUser")
    public String showAllUser(Model model) {
        List<User> allUsers = userDao.getAllUsers();
        model.addAttribute("allUser", allUsers);
        return "users";
    }
}
