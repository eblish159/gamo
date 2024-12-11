package fs.four.gamo.project.dao;

import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 특정 프로젝트의 상세 정보를 가져오는 메서드
    public ProjectVO getProjectDetails(int projectNo) {
        try {
            String sql = "SELECT project_no, project_title, project_content, project_progress, start_date, end_date " +
                    "FROM project WHERE project_no = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                ProjectVO project = new ProjectVO();
                project.setProjectNo(rs.getInt("project_no"));
                project.setProjectTitle(rs.getString("project_title"));
                project.setProjectContent(rs.getString("project_content"));
                project.setProjectProgress(rs.getInt("project_progress"));
                project.setStartDate(rs.getDate("start_date"));
                project.setEndDate(rs.getDate("end_date"));
                return project;
            }, projectNo);
        } catch (Exception e) {
            return null; // 프로젝트가 없거나 오류 발생 시 null 반환
        }
    }

    // 새로운 프로젝트를 삽입하는 메서드 (기본 데이터만 저장)
    public void insertProject(ProjectVO project) {
        if (project.getProjectContent() == null || project.getProjectContent().isEmpty()) {
            throw new IllegalArgumentException("project_content 값이 비어 있습니다.");
        }

        String sql = "INSERT INTO project (project_title, project_content, created_date, updated_date) " +
                "VALUES (?, ?, SYSDATE, SYSDATE)";
        jdbcTemplate.update(sql,
                project.getProjectTitle(),
                project.getProjectContent());
    }

    // 프로젝트 데이터를 저장하는 메서드 (시작 날짜와 종료 날짜 포함)
    public void saveProjectWithDates(ProjectVO project) {
        if (project.getProjectContent() == null || project.getProjectContent().isEmpty()) {
            throw new IllegalArgumentException("project_content 값이 비어 있습니다.");
        }

        String sql = "INSERT INTO project (project_title, project_content, start_date, end_date, project_progress, created_date, updated_date) " +
                "VALUES (?, ?, ?, ?, ?, SYSDATE, SYSDATE)";
        jdbcTemplate.update(sql,
                project.getProjectTitle(),
                project.getProjectContent(),
                project.getStartDate(),
                project.getEndDate(),
                project.getProjectProgress());
    }

    // 프로젝트 진행률 업데이트 메서드 (추가된 기능)
    public void updateProgress(int projectNo, int progress) {
        String sql = "UPDATE project SET project_progress = ?, updated_date = SYSDATE WHERE project_no = ?";
        jdbcTemplate.update(sql, progress, projectNo);
    }
}
