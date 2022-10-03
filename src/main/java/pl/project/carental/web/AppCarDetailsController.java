package pl.project.carental.web;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.Car;
import pl.project.carental.domain.CarDetails;
import pl.project.carental.service.CarDetailsService;
import pl.project.carental.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AppCarDetailsController {

    private final CarService carService;
private final CarDetailsService carDetailsService;

    public AppCarDetailsController(CarService carService, CarDetailsService carDetailsService) {
        this.carService = carService;
        this.carDetailsService = carDetailsService;
    }



    @GetMapping ("/app/car/details")
    public ModelAndView show(){

        return new ModelAndView("AppCarDetails");
    }

    @RequestMapping("/app/car/details/{id}")
    @ResponseBody
    public ModelAndView showFinal(@PathVariable long id,
                                  HttpServletRequest request,
                                  HttpServletResponse response){

        Car car=carService.findById(id);
        CarDetails carDetail=carDetailsService.findById(id);

        request.setAttribute("id",id);
        request.setAttribute("brandd",car.getBrand());
        request.setAttribute("model",car.getModel());
        request.setAttribute("fuelType",carDetail.getFuelType());
        request.setAttribute("packageName",carDetail.getPackageName());
        request.setAttribute("power",carDetail.getPower());
        request.setAttribute("pph",carDetail.getPrice_per_hour());
        request.setAttribute("ppd",carDetail.getPrice_per_day());


        return new ModelAndView("AppCarDetails");
    }

}
