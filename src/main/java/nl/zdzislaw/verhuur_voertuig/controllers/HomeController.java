package nl.zdzislaw.verhuur_voertuig.controllers;

import nl.zdzislaw.verhuur_voertuig.model.Users.User;
import nl.zdzislaw.verhuur_voertuig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index() {
        return ("index");
    }

    @RequestMapping("/home")
    public String authenticatedUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails=null;
        if (authentication == null) {
            System.out.println("authentication is null.");
        }

        if (authentication.getPrincipal() instanceof UserDetails) {
            userDetails= (UserDetails) authentication.getPrincipal();
        }

        if (authentication.getDetails() instanceof UserDetails) {
            userDetails= (UserDetails) authentication.getDetails();
        }
        String username = userDetails.getUsername();
        User user = userService.findByUsername(username);
        System.out.println(user.toString());
        model.addAttribute("user",user);
        return "home";
    }


}

