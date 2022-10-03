package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.User;
import pl.project.carental.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AppChangePasswordController {
    private final UserService userService;

    public AppChangePasswordController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/app/editPassword")
    public ModelAndView show(){
        return new ModelAndView("appEditPassword");
    }

    @PostMapping("/app/editPassword")
    public ModelAndView change(@RequestParam String name,
                               @RequestParam String oldPassword,
                               @RequestParam String newPassword){
        List<User> userList=userService.findAll();
        for(User user:userList){
            if(name.toLowerCase().equals(user.getFirstname()) && oldPassword.toLowerCase().equals(user.getPassword().toLowerCase())){
                user.setPassword(newPassword);
                userService.saveUser(user);
                return new ModelAndView("appEditPasswordDone");
            }
        }
        for (User user:userList){
            if (!name.toLowerCase().equals(user.getFirstname()) || !oldPassword.toLowerCase().equals(user.getPassword())){
                return new ModelAndView("appEditPassword");
            }
        }


        return null;
    }
}
