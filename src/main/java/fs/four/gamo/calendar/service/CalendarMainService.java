package fs.four.gamo.calendar.service;

import fs.four.gamo.calendar.dao.CalendarMainDAO;
import fs.four.gamo.calendar.vo.CalendarMainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarMainService {

    @Autowired
    private CalendarMainDAO calendarMainDAO;

    /**
     * 특정 이벤트 조회
     * @param eventId 이벤트 ID
     * @return 조회된 CalendarMainVO 객체
     * @throws Exception 예외 처리
     */
    public CalendarMainVO getEventById(int eventId) throws Exception {
        return calendarMainDAO.CalendarEventsById(eventId);
    }

    /**
     * 새로운 이벤트 저장
     * @param calendarMainVO 저장할 이벤트 정보
     */
    public void insertCalendarEvent(CalendarMainVO calendarMainVO) {
        calendarMainDAO.insertCalendarEvent(calendarMainVO); // 저장 SQL 호출
    }
}
