package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.project.carental.domain.User;
import pl.project.carental.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView show() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
    public String login="";
    @PostMapping("/login")
    public String Stringsubmit(@RequestParam String name,
                               @RequestParam String password,
                               HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        List<User> usersList = userService.findAll();


        for (User user : usersList) {
            if (name.toLowerCase().equals(user.getFirstname().toLowerCase()) && password.toLowerCase().equals(user.getPassword().toLowerCase())) {
                HttpSession loginSession= request.getSession();
                response.addCookie(new Cookie("cookieName",user.getFirstname()));
                response.addCookie(new Cookie("cookieUserID",String.valueOf(user.getId())));
                loginSession.setAttribute("logged",true);
                loginSession.setAttribute("user",user);
                login=user.getFirstname();

                return "redirect:/app/dashboard";
            }
        }
        for (User user : usersList) {
            if (!name.toLowerCase().equals(user.getFirstname().toLowerCase()) || !password.toLowerCase().equals(user.getPassword().toLowerCase())) {

                return "redirect:/login";
            }
        }


        return "";
    }

}
