package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.Car;
import pl.project.carental.domain.CarDetails;
import pl.project.carental.service.CarDetailsService;
import pl.project.carental.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AppRentCarController {
    private final CarService carService;
    private final CarDetailsService carDetailsService;

    public AppRentCarController(CarService carService, CarDetailsService carDetailsService) {
        this.carService = carService;
        this.carDetailsService = carDetailsService;
    }

    @GetMapping("/app/rentCar")
    public ModelAndView show(HttpServletRequest request,
                             HttpServletResponse response){
        List<Car> carList=carService.findAll();
        request.setAttribute("carList",carList);

        return new ModelAndView("appRentCar");
    }
}
