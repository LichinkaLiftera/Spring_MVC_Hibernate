package prog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prog.model.User;
import prog.service.UserService;

import java.util.List;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage(){
        return "home-page";
    }

    @GetMapping("addUser")
    public String addUser(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "user/save-new-user";
    }

    @PostMapping("saveUser")
    public String saveUser(@ModelAttribute("user") User user){

        userService.createUser(user);

        return "redirect:allUsers";
    }

    @GetMapping("allUsers")
    public String allUsers(Model model){
        List<User> userList = userService.getAllUsers();
        if(userList == null){
            return "user/no-users";
        }else{
        model.addAttribute("allUsers", userList);
        return "user/users-list";
        }
    }
    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping("updateUser/{id}")
    public String updateUser(Model model, @PathVariable("id") int id){
        User user = userService.readUser(id);
        model.addAttribute("user",user);
        return "user/updateUser-page";
    }
    @PutMapping("updateUser")
    public String patchUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:allUsers";
    }
}
