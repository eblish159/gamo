package fs.four.gamo.project.vo;

import java.util.Date;

public class TodoVO {
    private int todoId;         // 할일 ID
    private int projectNo;      // 프로젝트 번호
    private String description; // 할일 설명
    private int progress;       // 진행률
    private String todoName;    // 사용자 이름
    private Date createdDate;   // 생성 날짜
    private Date updatedDate;   // 수정 날짜

    // Getters and Setters
    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        this.description = description;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        if (progress < 0 || progress > 100) {
            throw new IllegalArgumentException("Progress must be between 0 and 100.");
        }
        this.progress = progress;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        if (todoName == null || todoName.trim().isEmpty()) {
            throw new IllegalArgumentException("Todo name cannot be null or empty.");
        }
        this.todoName = todoName;
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

    // toString Method for debugging
    @Override
    public String toString() {
        return "TodoVO{" +
                "todoId=" + todoId +
                ", projectNo=" + projectNo +
                ", description='" + description + '\'' +
                ", progress=" + progress +
                ", todoName='" + todoName + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
