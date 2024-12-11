package fs.four.gamo.calendarevents.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Component("calendarEventsVO")
public class CalendarEventsVO {
    private int eventId;
    private String eventType;
    private String title;
    private String details;
    private Date startDate;
    private Date endDate;
    private int isPrivate;
}