package fs.four.gamo.calendar.service;

import fs.four.gamo.calendar.dao.CalendarMainDAO;
import fs.four.gamo.calendar.vo.CalendarMainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarMainService {
    @Autowired
    private CalendarMainDAO calendarMainDAO;

    public CalendarMainVO calendar(CalendarMainVO calendarMainVO) throws Exception{
        return calendarMainDAO.CalendarEventsById(calendarMainVO);
    }
}
