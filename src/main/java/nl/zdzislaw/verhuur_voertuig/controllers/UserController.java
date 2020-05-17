package nl.zdzislaw.verhuur_voertuig.controllers;



import nl.zdzislaw.verhuur_voertuig.model.Users.User;
import nl.zdzislaw.verhuur_voertuig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute @Valid User user,
                          BindingResult bindResult) {
        if (bindResult.hasErrors()){
            System.out.println(bindResult.toString());
            return "registerForm";
        }
        else {
            user.setEnabled(true);
            user.setRoleName("ROLE_USER");
            userService.addWithDefaultRole(user);
            return "registerSuccess";
        }

    }

    @GetMapping("/showAllUsers")
    public String showAllUsers(Model model){
        List<User> allUsers=userService.showAllUsers();
        model.addAttribute("allUsers",allUsers);
    return "allUsers";
    }

}
