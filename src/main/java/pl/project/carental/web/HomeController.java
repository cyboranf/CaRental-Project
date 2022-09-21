package pl.project.carental.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping ("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }
}
