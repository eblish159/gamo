package fs.four.gamo.calendar.controller;

import fs.four.gamo.calendar.dao.CalendarDAO;
import fs.four.gamo.calendar.service.CalendarMainService;
import fs.four.gamo.calendar.vo.CalendarMainVO;
import fs.four.gamo.member.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @GetMapping("/callist")
    public String list_cal(Model model) {
        List<CalendarMainVO> eventcal = calendarMainService.list_cal();
        model.addAttribute("eventcal", eventcal);
        model.addAttribute("contentPage", "calendarContent/calendar");
        return "layout";
    }

    @PostMapping("/addEvent")
    public String addEvent(@ModelAttribute CalendarMainVO calendarMainVO) {
        calendarMainService.addEvent(calendarMainVO);
        return "redirect:/calendar";
    }

    @GetMapping("/delEvent")
    public String delEvent(@RequestParam("id") Long cal_no) {
        calendarMainService.delEvent(cal_no);
        return "redirect:/calendar";
    }
}
