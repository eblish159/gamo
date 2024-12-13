package fs.four.gamo.calendar.dao;

import fs.four.gamo.calendar.vo.CalendarMainVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

@Mapper
public interface CalendarMainDAO {

    /**
     * 특정 이벤트 조회 메서드
     * @param calendarMainVO CalendarMainVO 객체
     * @return CalendarMainVO 특정 이벤트 데이터
     * @throws DataAccessException 데이터 접근 오류 시 예외 처리
     */
    public CalendarMainVO CalendarEventsById(int calendarMainVO) throws DataAccessException;

    /**
     * 캘린더 이벤트 추가 메서드
     * @param calendarMainVO CalendarMainVO 객체
     */
    void insertCalendarEvent(CalendarMainVO calendarMainVO);
}