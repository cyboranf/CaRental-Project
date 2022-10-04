package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.AccessKey;
import pl.project.carental.domain.Car;
import pl.project.carental.domain.CarDetails;
import pl.project.carental.domain.User;
import pl.project.carental.service.AccessKeyService;
import pl.project.carental.service.CarDetailsService;
import pl.project.carental.service.CarService;
import pl.project.carental.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

        List<Car> carList=new ArrayList<>();
        carList.add(myCar);

        for (User user : userList) {
            if (user.getFirstname().equals(name)) {
                myUser = user;
            }
        }

        int hoursToData = hours+(days*24);

        AccessKey ak = new AccessKey(myCarDetails.getPackageName(), hoursToData, myUser,String.valueOf(accessKey+1));

//        LocalDate date=LocalDate.now();
//        LocalTime time=LocalTime.now();
//        String dueTo="";
//
//        int day = date.getDayOfMonth() + days;
//        int hour=time.getHour()+hoursToData;
//
//        LocalDate dateData=LocalDate.of(date.getYear(),date.getMonthValue(),day);
//        LocalTime timeData=LocalTime.of(hour,time.getMinute());
//
//        String finalDateData=dateData.toString();
//        String finalTimeData=timeData.toString();
//
//        dueTo=finalDateData;


        request.setAttribute("carList",carList); //brand //model //type
        request.setAttribute("id",id);
        request.setAttribute("ak",ak.getaKey());
//        request.setAttribute("dueTo",dueTo);


        return new ModelAndView("appProfile");
    }
}

