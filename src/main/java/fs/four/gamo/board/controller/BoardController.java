package fs.four.gamo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("pageTitle", "게시판"); // 게시판 제목
        model.addAttribute("message", "게시판 목록 페이지입니다."); // 게시판 메시지
        model.addAttribute("contentPage", "boardall/boardMain"); // contentPage 값 설정 (board/board.jsp 포함)
        return "layout"; // layout.jsp를 반환
    }

    @GetMapping("/newPost")
    //매핑 뭐로할지 주소입력이걸로
    public String project(Model model) {
        model.addAttribute("pageTitle", "프로젝트"); // 페이지 제목 설정
        model.addAttribute("message", "프로젝트 리스트 페이지"); // 메시지 설정
        model.addAttribute("contentPage", "boardall/boardWrite"); // contentPage 값을 설정 (projectall/projects.jsp 파일을 포함)
        return "layout"; // layout.jsp를 반환 (layout.jsp에서 contentPage를 사용하여 동적 포함)
    }

}
