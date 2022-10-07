package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.*;
import pl.project.carental.service.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppProfileController {

    private final UserService userService;
    private final CarService carService;
    private final CarDetailsService carDetailsService;
    private final AccessKeyService accessKeyService;
    private final RentedCarService rentedCarService;

    public AppProfileController(UserService userService, CarService carService, CarDetailsService carDetailsService, AccessKeyService accessKeyService, RentedCarService rentedCarService) {
        this.userService = userService;
        this.carService = carService;
        this.carDetailsService = carDetailsService;
        this.accessKeyService = accessKeyService;
        this.rentedCarService = rentedCarService;
    }

    public int accessKey = 688215; //6cyfr

    @GetMapping("/app/profile")
    public ModelAndView show() {

        return new ModelAndView("appProfile");
    }

    @RequestMapping("/app/profile/{id}/{name}")
    @ResponseBody
    @PostMapping("/app/profile/{id}/{name}")
    public ModelAndView showProfileData(@PathVariable long id,
                                        @PathVariable String name,
                                        @RequestParam int days,
                                        @RequestParam int hours,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
        Car myCar = carService.findById(id);
        myCar.setIs_available(false);
        CarDetails myCarDetails = carDetailsService.findById(id);

        User myUser = null;
        List<User> userList = userService.findAll();

        List<Car> carList = new ArrayList<>();
        carList.add(myCar);

        for (User user : userList) {
            if (user.getFirstname().equals(name)) {
                myUser = user;
            }
        }

        int hoursToData = hours + (days * 24);


        AccessKey accessKey2 = new AccessKey();
        accessKey2.setCarPackage(myCarDetails.getPackageName());
        accessKey2.setHours(hoursToData);
        accessKey2.setUser(myUser);
        accessKey2.setaKey(String.valueOf(accessKey + 1));

        accessKeyService.saveAccessKey(accessKey2);

        LocalDate localDateNow = LocalDate.now();
        LocalTime localTimeNow = LocalTime.now();

        LocalDate date1 = LocalDate.of(localDateNow.getYear(), localDateNow.getMonthValue(), localDateNow.getDayOfMonth() + days);
        LocalTime time1 = LocalTime.of(localTimeNow.getHour() + hours, localTimeNow.getMinute());

        String time = time1.toString();
        String date = date1.toString();

        int price = (int) ((hours * myCarDetails.getPrice_per_hour()) + (days * (10 * myCarDetails.getPrice_per_hour())));


        request.setAttribute("id", id);
        request.setAttribute("ak", accessKey2.getaKey());
        request.setAttribute("date", date);
        request.setAttribute("time", time);
        request.setAttribute("cost", String.valueOf(price));


        HttpSession loginSession = request.getSession();
        loginSession.setAttribute("rented", true);


        Cookie[] cookies = request.getCookies();

        long userId = 0;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cookieUserID")) {
                userId = Long.parseLong(cookie.getValue());
            }
        }

        RentedCar rentedCar = new RentedCar();
        rentedCar.setUserId(userId);
        rentedCar.setCarId(id);
        rentedCar.setCarBrand(myCar.getBrand());
        rentedCar.setCarModel(myCar.getModel());
        rentedCar.setCarType(myCar.getType());
        rentedCar.setAccessKey(accessKey2.getaKey());
        rentedCar.setDate(date);
        rentedCar.setTime(time);
        rentedCar.setPrice(price);
        rentedCar.setAvail(false);



        rentedCarService.saveRentedCar(rentedCar);
        List<RentedCar> listToShow = rentedCarService.findAllByUserId(userId);

        request.setAttribute("rentedCar", listToShow);


        return new ModelAndView("appProfile");
    }

    @RequestMapping("/app/profile/{id}")
    @ResponseBody
    public ModelAndView showProfileWUserID(@PathVariable long id,
                                           HttpServletRequest request) {

        List<RentedCar> rentedCars = rentedCarService.findAllByUserId(id);
        List<RentedCar> finalList = new ArrayList<>();
        for (RentedCar rentedCar : rentedCars) {
            if (rentedCar.isAvail() == false) {
                finalList.add(rentedCar);
            }
        }
        request.setAttribute("rentedCar", finalList);

        return new ModelAndView("appProfile");
    }
}

