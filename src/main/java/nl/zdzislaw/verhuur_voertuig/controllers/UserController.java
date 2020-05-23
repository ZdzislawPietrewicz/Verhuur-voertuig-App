package nl.zdzislaw.verhuur_voertuig.controllers;



import nl.zdzislaw.verhuur_voertuig.model.Users.Address;
import nl.zdzislaw.verhuur_voertuig.model.Users.User;
import nl.zdzislaw.verhuur_voertuig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView register() {
        ModelAndView modelAndView=new ModelAndView("registerForm");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("address", new Address());
        return modelAndView ;
    }

    @PostMapping("/registerProcess")
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

    @GetMapping("/admin/showAllUsers")
    public String showAllUsers(Model model){
        List<User> allUsers=userService.showAllUsers();
        model.addAttribute("allUsers",allUsers);
        for (User user: allUsers) {
            System.out.println(user.toString());
        }
    return "admin/allUsers";
    }

}
