package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.Car;
import pl.project.carental.domain.CarDetails;
import pl.project.carental.service.CarDetailsService;
import pl.project.carental.service.CarService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class RentSureController {
    private final CarService carService;
    private final CarDetailsService carDetailsService;

    public RentSureController(CarService carService, CarDetailsService carDetailsService) {
        this.carService = carService;
        this.carDetailsService = carDetailsService;
    }

    @GetMapping("/app/sureRent")
    public ModelAndView show() {
        return new ModelAndView("rentSure");
    }

    @RequestMapping("/app/sureRent/{id}")
    @ResponseBody
    public ModelAndView showSure(@PathVariable long id,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

        Car car = carService.findById(id);
        CarDetails carDetail = carDetailsService.findById(id);

        request.setAttribute("id", id);
        request.setAttribute("brandd", car.getBrand());
        request.setAttribute("model", car.getModel());
        request.setAttribute("fuelType", carDetail.getFuelType());
        request.setAttribute("packageName", carDetail.getPackageName());
        request.setAttribute("power", carDetail.getPower());
        request.setAttribute("pph", carDetail.getPrice_per_hour());
        request.setAttribute("ppd", carDetail.getPrice_per_day());

        response.addCookie(new Cookie("car", String.valueOf(request.getAttribute("id"))));


        return new ModelAndView("rentSure");
    }

    @PostMapping("/app/sureRent/{id}")
    public ModelAndView withForm(@RequestParam int days, @RequestParam int hours,
                                 @PathVariable long id,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        Car car = carService.findById(id);
        CarDetails carDetail = carDetailsService.findById(id);




        request.setAttribute("id", id);
        request.setAttribute("brandd", car.getBrand());
        request.setAttribute("model", car.getModel());
        request.setAttribute("fuelType", carDetail.getFuelType());
        request.setAttribute("packageName", carDetail.getPackageName());
        request.setAttribute("power", carDetail.getPower());
        request.setAttribute("pph", carDetail.getPrice_per_hour());
        request.setAttribute("ppd", carDetail.getPrice_per_day());




        request.setAttribute("d", days);
        request.setAttribute("h", hours);

        Cookie[] cookies=request.getCookies();

        for (Cookie cookie:cookies){
            cookie.setMaxAge(0);
            response.addCookie(cookie);

        }


        return new ModelAndView("rentSure");
    }
}
