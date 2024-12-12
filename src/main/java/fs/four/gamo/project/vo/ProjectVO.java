package fs.four.gamo.project.vo;

import java.sql.Date;

public class ProjectVO {
    private int projectNo;
    private String projectTitle;
    private String projectContent;
    private int projectProgress = 0;;     // camelCase로 변경
    private String projectCategory;   // camelCase로 변경
    private String memberId;          // camelCase로 변경
    private Date startDate;           // 기존 추가된 필드
    private Date endDate;             // 기존 추가된 필드
    private Date createdDate;         // camelCase로 변경
    private Date updatedDate;         // camelCase로 변경

    // Getters and Setters

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public int getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(int projectProgress) {
        this.projectProgress = projectProgress;
    }

    public String getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
