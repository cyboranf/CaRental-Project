package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.service.CarService;

@Controller
public class AppCarsController {
    private final CarService carService;

    public AppCarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/app/car/list")
    public ModelAndView show() {
        return new ModelAndView("cars");
    }
}
