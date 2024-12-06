package fs.four.gamo.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String home() {
        System.out.println("HomeController 실행");
        return "test";
    }
}
