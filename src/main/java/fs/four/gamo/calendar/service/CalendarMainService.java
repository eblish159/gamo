package fs.four.gamo.calendar.service;

import fs.four.gamo.calendar.dao.CalendarDAO;
import fs.four.gamo.calendar.vo.CalendarMainVO;
import fs.four.gamo.member.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarMainService {
    @Autowired
    private CalendarDAO calendarDAO;

    public List<CalendarMainVO> list_cal() {
        System.out.println(calendarDAO.toString());
        return calendarDAO.CalendarEvents();
    }

    public void addEvent(CalendarMainVO calendarMainVO) {
        calendarDAO.calendarEvents(calendarMainVO);
        System.out.println(calendarMainVO.toString());
    }

    public void delEvent(int cal_no) {
        calendarDAO.delete_cal(cal_no);
        System.out.println(cal_no);
    }
}
