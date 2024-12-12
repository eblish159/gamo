package fs.four.gamo.project.dao;

import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 특정 프로젝트의 상세 정보를 가져오는 메서드
    public ProjectVO getProjectDetails(int projectNo) {
        String sql = "SELECT project_no, project_title, project_content, project_progress, start_date, end_date " +
                "FROM project WHERE project_no = ?";
        try {
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

    // 모든 프로젝트 목록을 가져오는 메서드
    public List<ProjectVO> getAllProjects() {
        String sql = "SELECT project_no, project_title, project_content, project_progress, start_date, end_date, created_date " +
                "FROM project ORDER BY created_date DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ProjectVO project = new ProjectVO();
            project.setProjectNo(rs.getInt("project_no"));
            project.setProjectTitle(rs.getString("project_title"));
            project.setProjectContent(rs.getString("project_content"));
            project.setProjectProgress(rs.getInt("project_progress"));
            project.setStartDate(rs.getDate("start_date"));
            project.setEndDate(rs.getDate("end_date"));
            project.setCreatedDate(rs.getDate("created_date"));
            return project;
        });
    }

    // 종료된 프로젝트 목록을 가져오는 메서드
    public List<ProjectVO> getEndedProjects() {
        String sql = "SELECT project_no, project_title, project_content, project_progress, start_date, end_date, created_date " +
                "FROM project WHERE project_progress = 100 ORDER BY end_date DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ProjectVO project = new ProjectVO();
            project.setProjectNo(rs.getInt("project_no"));
            project.setProjectTitle(rs.getString("project_title"));
            project.setProjectContent(rs.getString("project_content"));
            project.setProjectProgress(rs.getInt("project_progress"));
            project.setStartDate(rs.getDate("start_date"));
            project.setEndDate(rs.getDate("end_date"));
            project.setCreatedDate(rs.getDate("created_date"));
            return project;
        });
    }

    // 프로젝트 데이터를 기본 정보로 삽입하는 메서드
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

    // 프로젝트 데이터를 시작 날짜와 종료 날짜를 포함해 저장하는 메서드
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

    // 프로젝트 진행률 업데이트 메서드
    public void updateProgress(int projectNo, int progress) {
        String sql = "UPDATE project SET project_progress = ?, updated_date = SYSDATE WHERE project_no = ?";
        jdbcTemplate.update(sql, progress, projectNo);
    }

    // 프로젝트 삭제 메서드
    public int deleteProjectById(int projectNo) {
        try {
            String sql = "DELETE FROM project WHERE project_no = ?";
            return jdbcTemplate.update(sql, projectNo); // 삭제된 행 수 반환
        } catch (Exception e) {
            e.printStackTrace(); // 예외 로그 출력
            return 0; // 실패 시 0 반환
        }
    }

    // 프로젝트 상세 정보를 ID로 가져오는 메서드
    public ProjectVO getProjectDetailsById(int projectNo) {
        return getProjectDetails(projectNo);
    }
}
