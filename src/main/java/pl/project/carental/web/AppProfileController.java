package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.AccessKey;
import pl.project.carental.domain.Car;
import pl.project.carental.domain.CarDetails;
import pl.project.carental.domain.User;
import pl.project.carental.dto.RentCarList;
import pl.project.carental.service.AccessKeyService;
import pl.project.carental.service.CarDetailsService;
import pl.project.carental.service.CarService;
import pl.project.carental.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AppProfileController {

    private final UserService userService;
    private final CarService carService;
    private final CarDetailsService carDetailsService;
    private final AccessKeyService accessKeyService;

    public AppProfileController(UserService userService, CarService carService, CarDetailsService carDetailsService, AccessKeyService accessKeyService) {
        this.userService = userService;
        this.carService = carService;
        this.carDetailsService = carDetailsService;
        this.accessKeyService = accessKeyService;
    }

    public int accessKey = 688215; //6cyfr
    public Map<Integer, List<RentCarList>> finalMap = new HashMap<>();
    public List<RentCarList> finalList = new ArrayList<>();

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

        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        LocalDate date1 = LocalDate.of(dateNow.getYear(), dateNow.getMonthValue(), dateNow.getDayOfMonth() + days);
        LocalTime time1 = LocalTime.of(timeNow.getHour() + hours, timeNow.getMinute());

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

        int userId = 0;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cookieUserID")) {
                userId = Integer.parseInt(cookie.getValue());
            }
        }


        Cookie cookieAk = new Cookie("cookieAk", (String) request.getAttribute("ak"));
        response.addCookie(cookieAk);

        Cookie cookieDate = new Cookie("cookieDate", (String) request.getAttribute("date"));
        response.addCookie(cookieDate);

        Cookie cookieTime = new Cookie("cookieTime", (String) request.getAttribute("time"));
        response.addCookie(cookieTime);

        Cookie cookieCost = new Cookie("cookieCost", (String) request.getAttribute("cost"));
        response.addCookie(cookieCost);

        Cookie cookieId = new Cookie("cookieId", String.valueOf(myCar.getId()));
        response.addCookie(cookieId);

        Cookie cookieBrand = new Cookie("cookieBrand", myCar.getBrand());
        response.addCookie(cookieBrand);

        Cookie cookieModel = new Cookie("cookieModel", myCar.getModel());
        response.addCookie(cookieModel);

        Cookie cookieType = new Cookie("cookieType", myCar.getType());
        response.addCookie(cookieType);

        Cookie cookieHours = new Cookie("cookieHours", String.valueOf(hours));
        response.addCookie(cookieHours);

        Cookie cookieDays = new Cookie("cookieDays", String.valueOf(days));
        response.addCookie(cookieDays);


        return new ModelAndView("appProfile");
    }


}

