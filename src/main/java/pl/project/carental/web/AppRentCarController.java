package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.Car;
import pl.project.carental.domain.User;
import pl.project.carental.service.CarDetailsService;
import pl.project.carental.service.CarService;
import pl.project.carental.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppRentCarController {
    private final UserService userService;
    private final CarService carService;
    private final CarDetailsService carDetailsService;

    public AppRentCarController(UserService userService, CarService carService, CarDetailsService carDetailsService) {
        this.userService = userService;
        this.carService = carService;
        this.carDetailsService = carDetailsService;
    }

    @GetMapping("/app/rentCar")
    public ModelAndView show(HttpServletRequest request,
                             HttpServletResponse response){
        List<Car> carList=carService.findAll();
        List<Car> availCarList=new ArrayList<>();
        for (Car car:carList){
            if (car.getIs_available().equals(true)){
                availCarList.add(car);
            }
        }

        request.setAttribute("carList",availCarList);

        return new ModelAndView("appRentCar");
    }
}
