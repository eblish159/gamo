package fs.four.gamo.calendar.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Component("calendarMainVO")
public class CalendarMainVO {
    private int cal_no;
    private int gubun;
    private String calTitle;
    private String calDetails;
    private String startDate;
    private String endDate;
}
