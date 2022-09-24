package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutCotroller {
    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView mav = new ModelAndView("about");
        return mav;
    }
}
