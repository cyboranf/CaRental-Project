package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.Car;
import pl.project.carental.service.CarService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AppAddCarController {
    private final CarService carService;

    public AppAddCarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/app/car/add")
    public ModelAndView show(){
        ModelAndView mav=new ModelAndView("appCarAdd");
        return mav;
    }

    @PostMapping("/app/car/add")
    public ModelAndView save(@RequestParam String brand,
                             @RequestParam boolean isAvail,
                             @RequestParam String model,
                             @RequestParam String type,
                             HttpServletResponse response,
                             HttpServletRequest request) throws IOException {
        Car car=new Car();
        car.setBrand(brand);
        car.setIs_available(isAvail);
        car.setModel(model);
        car.setType(type);
        carService.saveCar(car);



        return new ModelAndView("appCarDetailsAdd");
    }
}
