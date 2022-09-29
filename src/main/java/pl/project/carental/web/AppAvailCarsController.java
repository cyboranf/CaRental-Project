package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.service.CarService;

@Controller
public class AppAvailCarsController {
    private final CarService carService;

    public AppAvailCarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/app/avail/cars")
    public ModelAndView show(){
        return new ModelAndView("appAvailCars");
    }
}
