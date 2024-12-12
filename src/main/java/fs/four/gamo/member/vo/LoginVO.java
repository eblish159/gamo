package fs.four.gamo.member.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component("loginVO")
public class LoginVO {
    private String member_id;
    private String member_pw;
    private String name;
    private String phone;
    private String gameonoff;
    private String img_name;
    private String img_path;
    private Date created_date;
    private String created_id;
    private Date updated_date;
    private String updated_id;
    private int role;

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGameonoff() {
        return gameonoff;
    }

    public void setGameonoff(String gameonoff) {
        this.gameonoff = gameonoff;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getCreated_id() {
        return created_id;
    }

    public void setCreated_id(String created_id) {
        this.created_id = created_id;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public String getUpdated_id() {
        return updated_id;
    }

    public void setUpdated_id(String updated_id) {
        this.updated_id = updated_id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
