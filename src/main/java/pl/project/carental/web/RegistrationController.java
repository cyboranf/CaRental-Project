package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.User;
import pl.project.carental.service.UserService;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public ModelAndView show() {

        return new ModelAndView("register");

    }

    @PostMapping("/register")
    public ModelAndView submit(@RequestParam String name,
                       @RequestParam String surname,
                       @RequestParam String email,
                       @RequestParam String password) {
        User user = new User();
        user.setFirstname(name);
        user.setLastname(surname);
        user.setEmail(email);
        user.setPassword(password);
        userService.saveUser(user);
        return new ModelAndView("/register");

    }


}
