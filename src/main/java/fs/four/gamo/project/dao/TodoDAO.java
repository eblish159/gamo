package fs.four.gamo.project.dao;

import fs.four.gamo.project.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 할일 저장
    public void saveTodo(TodoVO todo) {
        String sql = "INSERT INTO Todo (project_no, member_id, description, progress) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, todo.getProjectNo(), todo.getMemberId(), todo.getDescription(), todo.getProgress());
    }

    // 특정 프로젝트의 할일 목록 조회
    public List<TodoVO> getTodoListByProject(int projectNo) {
        String sql = "SELECT todo_id, project_no, member_id, description, progress FROM Todo WHERE project_no = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            TodoVO todo = new TodoVO();
            todo.setTodoId(rs.getInt("todo_id"));
            todo.setProjectNo(rs.getInt("project_no"));
            todo.setMemberId(rs.getString("member_id"));
            todo.setDescription(rs.getString("description"));
            todo.setProgress(rs.getInt("progress"));
            return todo;
        }, projectNo);
    }
}
