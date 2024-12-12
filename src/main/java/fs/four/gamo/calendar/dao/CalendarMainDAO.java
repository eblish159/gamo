package fs.four.gamo.calendar.dao;

import fs.four.gamo.calendar.vo.CalendarMainVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

@Mapper
public interface CalendarMainDAO {
    public CalendarMainVO CalendarEventsById(CalendarMainVO calendarMainVO) throws DataAccessException;
}
