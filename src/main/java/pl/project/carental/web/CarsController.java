package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.Car;
import pl.project.carental.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarsController {
    private final CarService carService;



    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ModelAndView cars(HttpServletRequest request){
        ModelAndView mav=new ModelAndView("cars");
        List<Car> carList=carService.findAll();

        request.setAttribute("carList",carList);
        return mav;
    }
}
