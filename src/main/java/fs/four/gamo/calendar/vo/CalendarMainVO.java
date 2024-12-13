package fs.four.gamo.calendar.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Component("calendarMainVO")
public class CalendarMainVO {
    private Long cal_no;
    private int gubun;
    private String cal_Title;
    private String cal_Details;
    private Date start_Date;
    private Date end_Date;
}
