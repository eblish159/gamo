package fs.four.gamo.project.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectParticipantVO {
    private int projectNo;
    private String memberId;
    private String name;
    // 기본 생성자
    public ProjectParticipantVO() {}

    // 생성자
    public ProjectParticipantVO(int projectNo, String memberId) {
        this.projectNo = projectNo;
        this.memberId = memberId;
    }
}
