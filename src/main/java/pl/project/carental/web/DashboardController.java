package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
    @GetMapping("/app/dashboard")
    public ModelAndView contact(){
        ModelAndView mav=new ModelAndView("dashboard");
        return mav;
    }
}
