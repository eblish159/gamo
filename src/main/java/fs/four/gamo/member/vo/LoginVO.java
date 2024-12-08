package fs.four.gamo.member.vo;

import lombok.Data;

@Data
public class LoginVO {
    private String member_id;
    private String member_pw;
    private String name;
    private String phone;
    private String gameonoff;
    private String img_name;
    private String img_path;
    private String created_date;
    private String created_id;
    private String updated_date;
    private String updated_id;
}
