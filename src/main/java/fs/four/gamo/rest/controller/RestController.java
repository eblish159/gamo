package fs.four.gamo.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {


    @GetMapping("/rest1")
    //매핑 뭐로할지 주소입력이걸로
    public String rest1(Model model) {
        model.addAttribute("pageTitle", "업다운"); // 페이지 제목 설정
        model.addAttribute("message", "업다운게임"); // 메시지 설정
        model.addAttribute("contentPage", "rest/rest_game_1"); // contentPage 값을 설정 (projectall/projects.jsp 파일을 포함)
        return "layout"; // layout.jsp를 반환 (layout.jsp에서 contentPage를 사용하여 동적 포함)
    }

    @GetMapping("/rest2")
    //매핑 뭐로할지 주소입력이걸로
    public String rest2(Model model) {
        model.addAttribute("pageTitle", "가위바위보"); // 페이지 제목 설정
        model.addAttribute("message", "가위바위보게임"); // 메시지 설정
        model.addAttribute("contentPage", "rest/rest_game_2"); // contentPage 값을 설정 (projectall/projects.jsp 파일을 포함)
        return "layout"; // layout.jsp를 반환 (layout.jsp에서 contentPage를 사용하여 동적 포함)
    }
}
