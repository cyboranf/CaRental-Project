package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarsController {
    @GetMapping("/cars")
    public ModelAndView cars(){
        ModelAndView mav=new ModelAndView("cars");
        return mav;
    }
}
