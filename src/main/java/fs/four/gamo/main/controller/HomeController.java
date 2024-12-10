package fs.four.gamo.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "홈");
        model.addAttribute("message", "환영합니다!");
        model.addAttribute("contentPage", "homeContent"); // 동적으로 삽입할 JSP
        return "layout"; // layout.jsp를 반환
    }

    @GetMapping("/calendar2")
    public String calendar(Model model) {
        model.addAttribute("pageTitle", "캘린더");
        model.addAttribute("message", "캘린더 관리 페이지");
        model.addAttribute("contentPage", "calendarContent");
        return "layout"; // layout.jsp를 반환
    }
}


