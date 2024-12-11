package fs.four.gamo.calendar.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Component("calendarMainVO")
public class CalendarMainVO {
    private int eventId;
    private Date event_Date;
    private String event_Name;
    private String event_Color;
    private String event_Description;
}