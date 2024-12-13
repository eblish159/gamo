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
    private String cal_title;
    private String cal_details;
    private Date start_date;
    private Date end_date;

    public Long getCal_no() {
        return cal_no;
    }

    public void setCal_no(Long cal_no) {
        this.cal_no = cal_no;
    }

    public int getGubun() {
        return gubun;
    }

    public void setGubun(int gubun) {
        this.gubun = gubun;
    }

    public String getCal_title() {
        return cal_title;
    }

    public void setCal_title(String cal_title) {
        this.cal_title = cal_title;
    }

    public String getCal_details() {
        return cal_details;
    }

    public void setCal_details(String cal_details) {
        this.cal_details = cal_details;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
