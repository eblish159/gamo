package fs.four.gamo.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "홈");
        model.addAttribute("message" , "환영합니다!");
        model.addAttribute("contentPage" , "homeController");
        return "layout";
    }

    @GetMapping("/calendar")
    public String calendar(Model model) {
        model.addAttribute("pageTitle", "캘린더");
    }
}
