package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.Car;
import pl.project.carental.domain.CarDetails;
import pl.project.carental.service.CarDetailsService;
import pl.project.carental.service.CarService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RentSureController {
    private final CarService carService;
    private final CarDetailsService carDetailsService;

    public RentSureController(CarService carService, CarDetailsService carDetailsService) {
        this.carService = carService;
        this.carDetailsService = carDetailsService;
    }
    @GetMapping("/app/sureRent")
    public ModelAndView show(){
        return new ModelAndView("rentSure");
    }

    @RequestMapping("/app/sureRent/{id}")
    @ResponseBody
    public ModelAndView showSure(@PathVariable long id,
                                 HttpServletRequest request){

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


        return new ModelAndView("rentSure");
    }
}
