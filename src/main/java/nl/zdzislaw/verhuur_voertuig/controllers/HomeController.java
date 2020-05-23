package nl.zdzislaw.verhuur_voertuig.controllers;

import nl.zdzislaw.verhuur_voertuig.model.Users.User;
import nl.zdzislaw.verhuur_voertuig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return ("index");
    }

    @GetMapping("/home")
    public String authenticatedUser(Model model, HttpSession session) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails=null;


        if (authentication.getPrincipal() instanceof UserDetails) {
            userDetails= (UserDetails) authentication.getPrincipal();
        }

        if (authentication.getDetails() instanceof UserDetails) {
            userDetails= (UserDetails) authentication.getDetails();
        }
        String username = userDetails.getUsername();
        User user = userService.findByUsername(username);
        session.setAttribute("user", user);
        model.addAttribute("user",user);
        return "home";
    }


}

