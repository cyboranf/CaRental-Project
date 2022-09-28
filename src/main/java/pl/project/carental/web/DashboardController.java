package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.Car;
import pl.project.carental.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DashboardController {
    private final CarService carService;

    public DashboardController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/app/dashboard")
    public ModelAndView contact(HttpServletRequest request,
                                HttpServletResponse response){
        ModelAndView mav=new ModelAndView("dashboard");
        int numberOfCars=0;
        List<Car> carList=carService.findAll();
        for (Car car:carList){
            numberOfCars+=1;
        }
        request.setAttribute("numberOfCars",numberOfCars);
        return mav;
    }
}
