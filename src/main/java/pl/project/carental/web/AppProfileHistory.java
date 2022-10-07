package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.RentedCar;
import pl.project.carental.service.RentedCarService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppProfileHistory {
    private final RentedCarService rentedCarService;

    public AppProfileHistory(RentedCarService rentedCarService) {
        this.rentedCarService = rentedCarService;
    }

    @RequestMapping("/app/profile/history/{id}")
    @ResponseBody
    public ModelAndView show(@PathVariable long id,
                             HttpServletRequest request){
        LocalTime localTimeNow=LocalTime.now();
        LocalDate localDateNow=LocalDate.now();

        List<RentedCar> rentedCars=rentedCarService.findAllByUserId(id);

        for (RentedCar rentedCar:rentedCars){
            String []stringDate=rentedCar.getDate().split("-");
            int daysFromDataB=Integer.parseInt(stringDate[2]);

            String []stringTime=rentedCar.getTime().split(":");
            int hoursFromDataB=Integer.parseInt(stringTime[0]);
            int minutesFromDataB=Integer.parseInt(stringTime[1]);

            if(localDateNow.getDayOfMonth()>=daysFromDataB){
                if (localTimeNow.getHour()>=hoursFromDataB){
                    if (localTimeNow.getMinute()>minutesFromDataB){
                        rentedCar.setAvail(true);
                    }
                }
            }
        }

        List<RentedCar> finalList=new ArrayList<>();
        for (RentedCar rentedCar3:rentedCars){
            if (rentedCar3.isAvail()==true){
                finalList.add(rentedCar3);
            }
        }
        request.setAttribute("rentedCar", finalList);



        return new ModelAndView("appProfileHistory");
    }

}
