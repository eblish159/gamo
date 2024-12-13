package fs.four.gamo.calendar.dao;

import fs.four.gamo.calendar.vo.CalendarMainVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalendarDAO {
    List<CalendarMainVO> CalendarEvents();
    public void calendarEvents(CalendarMainVO calendarMainVO);
    public void delete_cal(int cal_no);
    public void delete_cal(Long cal_no);
}

