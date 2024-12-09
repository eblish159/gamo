package fs.four.gamo.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageModalController {

    @GetMapping("/mypagemodal")
    //매핑 뭐로할지 주소입력이걸로
    public String project(Model model) {
        model.addAttribute("pageTitle", "마이페이지 모달"); // 페이지 제목 설정
        model.addAttribute("message", "마이페이지 모달항목"); // 메시지 설정
        model.addAttribute("contentPage", "mypagemodal"); // contentPage 값을 설정 (projectall/projects.jsp 파일을 포함)
        return "layout"; // layout.jsp를 반환 (layout.jsp에서 contentPage를 사용하여 동적 포함)
    }
}
