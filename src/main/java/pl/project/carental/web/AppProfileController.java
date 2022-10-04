package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.service.UserService;

@Controller
public class AppProfileController {

    private final UserService userService;

    public AppProfileController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/app/profile")
    public ModelAndView show(){

        return new ModelAndView("appProfile");
    }
}

