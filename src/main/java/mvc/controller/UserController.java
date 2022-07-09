package mvc.controller;

import mvc.model.User;
import mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }


    @GetMapping()
    public String showAllUser(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUser", allUsers);
        return "users";
    }

//         ----------------------------------------------Add User----------------------------------------------     //
    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user_info_table";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
//      ---------------------------------------------------------------------------------------------------------   //

//      ----------------------------------------------Edit User--------------------------------------------------   //
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user_update_table";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }
//    ------------------------------------------------------------------------------------------------------------   //

//    ----------------------------------------------Delete User---------------------------------------------------   //
    @PostMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
