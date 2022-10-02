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
public class AppDashboardController {
    private final CarService carService;
    private final CarDetailsService carDetailsService;

    public AppDashboardController(CarService carService, CarDetailsService carDetailsService) {
        this.carService = carService;
        this.carDetailsService = carDetailsService;
    }

    @GetMapping("/app/dashboard")
    public ModelAndView contact(HttpServletRequest request,
                                HttpServletResponse response){
        ModelAndView mav=new ModelAndView("dashboard");
        int numberOfCars=0;
        int numberOfAvailCars=0;
        List<Car> carList=carService.findAll();
        for (Car car:carList){
            if(car.getIs_available().equals(true)){
                numberOfAvailCars+=1;
            }
            numberOfCars+=1;
        }
        request.setAttribute("numberOfCars",numberOfCars);
        request.setAttribute("numberOfAvailCars",numberOfAvailCars);

        Car lastCar=carList.get(numberOfCars-1);
        request.setAttribute("brand",lastCar.getBrand());
        request.setAttribute("model",lastCar.getModel());
        request.setAttribute("type",lastCar.getType());
        request.setAttribute("isAvail",lastCar.getIs_available());

        List<CarDetails> carDetailsList=carDetailsService.findAll();
        CarDetails lastCarDetail=carDetailsList.get(numberOfCars-1);
        request.setAttribute("pph",lastCarDetail.getPrice_per_hour());
        request.setAttribute("ppd",lastCarDetail.getPrice_per_day());

        return mav;
    }
}
