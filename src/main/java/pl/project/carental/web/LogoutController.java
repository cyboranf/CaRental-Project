package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public ModelAndView show(){
        return new ModelAndView("home");
    }
}
