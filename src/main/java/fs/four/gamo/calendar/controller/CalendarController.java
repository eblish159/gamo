package fs.four.gamo.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CalendarController {

    @GetMapping("/calendar")
    public String calendar(Model model) {
        model.addAttribute("pageTitle", "캘린더스");
        model.addAttribute("message", "캘린더 메뉴리스트");

        // 예제 데이터 추가
        List<Map<String, String>> calendarData = new ArrayList<>();
        Map<String, String> row1 = new HashMap<>();
        row1.put("date", "2024-12-01");
        row1.put("event", "회의");
        row1.put("location", "서울");
        calendarData.add(row1);

        Map<String, String> row2 = new HashMap<>();
        row2.put("date", "2024-12-02");
        row2.put("event", "워크샵");
        row2.put("location", "부산");
        calendarData.add(row2);

        model.addAttribute("calendarData", calendarData); // 데이터를 모델에 추가
        model.addAttribute("contentPage", "calendarContent/calendar");
        return "layout";
    }
}