package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.Car;
import pl.project.carental.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppCarsController {
    private final CarService carService;

    public AppCarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/app/car/list")
    public ModelAndView show(HttpServletRequest request,
                             HttpServletResponse response) {
        List<Car> carList=carService.findAll();

        request.setAttribute("carList",carList);

        return new ModelAndView("appCars");
    }
}
