package pl.project.carental.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @GetMapping("/app/logout")
    public ModelAndView show(HttpServletRequest request,
                             HttpServletResponse response){
        Cookie[] cookies=request.getCookies();
        HttpSession session= request.getSession();
        for (Cookie cookie:cookies){
            cookie.setMaxAge(0);
            response.addCookie(cookie);

        }

        return new ModelAndView("home");
    }
}
