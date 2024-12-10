package fs.four.gamo.project.dao;

import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProjectVO getProjectDetails() {
        try {
            String sql = "SELECT project_no, project_title, project_content FROM project WHERE project_no = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                ProjectVO project = new ProjectVO();
                project.setProjectNo(rs.getString("project_no"));
                project.setProjectTitle(rs.getString("project_title"));
                project.setProjectContent(rs.getString("project_content"));
                return project;
            }, 1); // 예제용 project_no를 하드코딩으로 지정
        } catch (Exception e) {
            return null;
        }
    }

    public void insertProject(ProjectVO project) {


        if (project.getProjectContent() == null || project.getProjectContent().isEmpty()) {
            throw new IllegalArgumentException("project_content 값이  비어 있습니다.");
        }

        String sql = "INSERT INTO project (project_title, project_content) VALUES (?, ?)";
        jdbcTemplate.update(sql,
                project.getProjectTitle(),
                project.getProjectContent());

    }
}
