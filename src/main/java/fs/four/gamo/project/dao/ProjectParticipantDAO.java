package fs.four.gamo.project.dao;

import fs.four.gamo.project.vo.ProjectParticipantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectParticipantDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 참여자 추가
    public void insertParticipant(ProjectParticipantVO participant) {
        String sql = "INSERT INTO Project_participant (project_no, member_id, created_date, updated_date) " +
                "VALUES (?, ?, SYSDATE, SYSDATE)";
        try {
            jdbcTemplate.update(sql, participant.getProjectNo(), participant.getMemberId());
        } catch (DuplicateKeyException e) {
            throw new RuntimeException("이미 참여자로 등록된 사용자입니다.");
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("데이터베이스 제약 조건 위반: " + e.getMessage());
        }
    }

    // 참여자 목록 조회
    public List<ProjectParticipantVO> selectParticipantsByProjectNo(int projectNo) {
        String sql = "SELECT p.project_no, p.member_id, m.name, p.created_date, p.updated_date " +
                "FROM Project_participant p " +
                "JOIN Member m ON p.member_id = m.member_id " +
                "WHERE p.project_no = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ProjectParticipantVO participant = new ProjectParticipantVO();
            participant.setProjectNo(rs.getInt("project_no"));
            participant.setMemberId(rs.getString("member_id"));
            participant.setName(rs.getString("name")); // name 필드 추가
            return participant;
        }, projectNo);
    }
}
