package fs.four.gamo.calendarevents.dao;

import fs.four.gamo.calendarevents.vo.CalendarEventsVO;
import fs.four.gamo.member.vo.LoginVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.Map;

@Mapper
public interface CalendarEventsDAO {
    public CalendarEventsVO CalendarEventsById(CalendarEventsVO calendarEventsVO) throws DataAccessException;
}
