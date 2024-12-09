package fs.four.gamo.member.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class LoginVO {
    private String member_id;
    private String member_pw;
    private String name;
    private String phone;
    private int gameonoff;
    private String img_name;
    private String img_path;
    private Date created_date;
    private String created_id;
    private Date updated_date;
    private String updated_id;
}
