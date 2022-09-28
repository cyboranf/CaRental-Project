package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.User;
import pl.project.carental.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView show() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView submit(@RequestParam String name,
                               @RequestParam String password) {
        List<User> usersList = userService.findAll();


        for (User user : usersList) {
            if (name.toLowerCase().equals(user.getFirstname().toLowerCase()) && password.toLowerCase().equals(user.getPassword().toLowerCase())) {
                return new ModelAndView("dashboard");
            }
        }
        for (User user : usersList) {
            if (!name.toLowerCase().equals(user.getFirstname().toLowerCase()) || !password.toLowerCase().equals(user.getPassword().toLowerCase())) {

                return new ModelAndView("login");
            }
        }


        return null;
    }

}
