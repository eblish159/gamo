package fs.four.gamo.calendar.dao;

import fs.four.gamo.calendar.vo.CalendarMainVO;
import fs.four.gamo.calendarevents.vo.CalendarEventsVO;
import fs.four.gamo.member.vo.LoginVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.Map;

@Mapper
public interface CalendarMainDAO {
    public CalendarMainVO CalendarEventsById(CalendarMainVO calendarMainVO) throws DataAccessException;
}
