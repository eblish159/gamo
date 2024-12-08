package fs.four.gamo.project.dao;

import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate; // JdbcTemplate을 주입받습니다.

    public ProjectVO getProjectDetails() {
        String sql = "SELECT project_title, project_content, project_period FROM project WHERE project_id = 1"; // 쿼리문 정의
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            // `queryForObject`는 하나의 결과를 가져오는 메서드로, 결과가 여러 개일 경우 예외가 발생합니다.
            ProjectVO project = new ProjectVO(); // 결과를 담을 VO 객체 생성
            project.setProjectTitle(rs.getString("project_title")); // DB의 `project_title` 값을 VO 객체에 설정
            project.setProjectContent(rs.getString("project_content")); // DB의 `project_content` 값을 VO 객체에 설정
            return project; // 데이터를 담은 VO 객체 반환
        });
    }
}

