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

    // 공통 데이터 설정 메서드
    private void setCommonAttributes(Model model, String pageTitle, String message, String contentPage) {
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("message", message);
        model.addAttribute("contentPage", contentPage);
    }

    // 캘린더 메인 페이지
    @GetMapping("/calendar")
    public String calendar(Model model) {
        setCommonAttributes(model, "캘린더스", "캘린더 메뉴리스트", "calendarContent/calendar");
        return "layout";
    }

    // To-Do 모달
    @GetMapping("/todomodal")
    public String todoModal(Model model) {
        setCommonAttributes(model, "캘린더스", "To-Do 모달", "calendarContent/todo");
        return "layout";
    }

    // 스케줄 모달
    @GetMapping("/schedulemodal")
    public String scheduleModal(Model model) {
        setCommonAttributes(model, "스케줄", "스케줄 모달", "calendarContent/schedule");
        return "layout";
    }

    // 이벤트 추가
    @PostMapping("/addEvent")
    public String addEvent(@ModelAttribute CalendarMainVO calendarMainVO, Model model) {
        try {
            calendarMainService.insertCalendarEvent(calendarMainVO); // 이벤트 저장
            model.addAttribute("message", "이벤트가 저장되었습니다!");
        } catch (Exception e) {
            model.addAttribute("message", "이벤트 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        return "redirect:/calendar"; // 캘린더 페이지로 리다이렉트
    }
}
