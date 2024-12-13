package fs.four.gamo.calendar.controller;

import fs.four.gamo.calendar.service.CalendarMainService;
import fs.four.gamo.calendar.vo.CalendarMainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalendarController {

    @Autowired
    private CalendarMainService calendarMainService; // 서비스 주입

    @GetMapping("/calendar")
    public String calendar(Model model) {
        model.addAttribute("pageTitle", "캘린더스");
        model.addAttribute("message", "캘린더 메뉴리스트");
        model.addAttribute("contentPage", "calendarContent/calendar");
        return "layout";
    }

    @GetMapping("/todomodal")
    public String todomodal(Model model) {
        model.addAttribute("pageTitle", "캘린더스");
        model.addAttribute("message", "캘린더 메뉴리스트");
        model.addAttribute("contentPage", "calendarContent/todo");
        return "layout";
    }

    @GetMapping("/schedulemodal")
    public String project(Model model) {
        model.addAttribute("pageTitle", "스케줄"); // 페이지 제목 설정
        model.addAttribute("message", "스케줄 모달"); // 메시지 설정
        model.addAttribute("contentPage", "calendarContent/schedule"); // contentPage 값을 설정
        return "layout"; // layout.jsp 반환
    }

    @PostMapping("/addEvent")
    public String addEvent(@ModelAttribute CalendarMainVO calendarMainVO, Model model) {
        calendarMainService.insertCalendarEvent(calendarMainVO); // 이벤트 저장
        model.addAttribute("message", "이벤트가 저장되었습니다!");
        return "redirect:/calendar"; // 캘린더 페이지로 리다이렉트
    }
}
