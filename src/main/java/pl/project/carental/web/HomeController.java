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

    @GetMapping ("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @GetMapping ("/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView("register");
        return mav;
    }

    @GetMapping ("/about")
    public ModelAndView about() {
        ModelAndView mav = new ModelAndView("about");
        return mav;
    }

    @GetMapping("/cars")
    public ModelAndView cars(){
        ModelAndView mav=new ModelAndView("cars");
        return mav;
    }
    @GetMapping("/contact")
    public ModelAndView contact(){
        ModelAndView mav=new ModelAndView("contact");
        return mav;
    }
}
