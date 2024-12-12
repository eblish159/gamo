package fs.four.gamo.board.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
public class BoardVO {
    private Long board_no;
    private String board_title;
    private String board_content;
    private String member_id;
    private Date created_date;
    private Date updated_date;

    public Long getBoard_no() {
        return board_no;
    }

    public void setBoard_no(Long board_no) {
        this.board_no = board_no;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }
}
