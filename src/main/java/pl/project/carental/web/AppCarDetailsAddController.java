package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.CarDetails;
import pl.project.carental.service.CarDetailsService;

@Controller
public class AppCarDetailsAddController {
    private final CarDetailsService carDetailsService;

    public AppCarDetailsAddController(CarDetailsService carDetailsService) {
        this.carDetailsService = carDetailsService;
    }

    @GetMapping("/app/carDetails/add")
    public ModelAndView show(){
        ModelAndView mav=new ModelAndView("appCarDetailsAdd");
        return mav;
    }

    @PostMapping("/app/carDetails/add")
    public ModelAndView save(@RequestParam String fuelType,
                             @RequestParam String PacName,
                             @RequestParam int power,
                             @RequestParam double ppd){
        CarDetails carDetails=new CarDetails();
        carDetails.setFuelType(fuelType);
        carDetails.setPackageName(PacName);
        carDetails.setPower(power);
        carDetails.setPrice_per_day(ppd);
        carDetails.setPrice_per_hour(ppd/10);
        carDetailsService.saveCarDetails(carDetails);
        return new ModelAndView("dashboard");

    }
}
