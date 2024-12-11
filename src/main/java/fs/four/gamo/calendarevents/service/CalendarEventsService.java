package fs.four.gamo.calendarevents.service;

import fs.four.gamo.calendarevents.vo.CalendarEventsVO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CalendarEventsService {

    public CalendarEventsVO CalendarEventsById(CalendarEventsVO calendarEventsVO) throws Exception {
        // DB 로직 수행
        return calendarEventsVO; // 실제로는 DB 조회 결과를 반환해야 함
    }
}