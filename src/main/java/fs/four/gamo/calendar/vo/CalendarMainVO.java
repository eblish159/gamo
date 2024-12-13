package fs.four.gamo.calendar.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Component("calendarMainVO")
public class CalendarMainVO {
    private int GUBUN;
    private String CAL_TITLE;
    private String CAL_DETAILS;
    private Date START_DATE;
    private Date  END_DATE;
    private int  SECRET;
}
