package fs.four.gamo.calendar.controller;

import fs.four.gamo.calendar.vo.CalendarMainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CalendarController {

    @Autowired
    private CalendarMainVO calendarMainVO;

    @GetMapping("/calendar")
    public String calendar(Model model) {
        model.addAttribute("pageTitle", "캘린더스");
        model.addAttribute("message", "캘린더 메뉴리스트");
        model.addAttribute("contentPage", "calendarContent/calendar");
        model.addAttribute("calendarMainVO",calendarMainVO);
        return "layout";
    }

    @GetMapping("/todomodal")
    public String todomodal(Model model) {
        model.addAttribute("pageTitle", "캘린더스");
        model.addAttribute("message", "캘린더 메뉴리스트");
        model.addAttribute("contentPage", "calendarContent/todo");
        model.addAttribute("calendarMainVO",calendarMainVO);
        return "layout";
    }
}