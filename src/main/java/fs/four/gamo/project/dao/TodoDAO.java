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
        String sql = "INSERT INTO Todo (project_no, description, progress, todo_name) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, todo.getProjectNo(), todo.getDescription(), todo.getProgress(), todo.getTodoName());
    }

    // 특정 프로젝트의 할일 목록 조회
    public List<TodoVO> getTodoListByProject(int projectNo) {
        String sql = "SELECT todo_id, project_no, description, progress, todo_name FROM Todo WHERE project_no = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            TodoVO todo = new TodoVO();
            todo.setTodoId(rs.getInt("todo_id"));
            todo.setProjectNo(rs.getInt("project_no"));
            todo.setDescription(rs.getString("description"));
            todo.setProgress(rs.getInt("progress"));
            todo.setTodoName(rs.getString("todo_name"));
            return todo;
        }, projectNo);
    }

    // 특정 할일 삭제
    public void deleteTodoById(int todoId) {
        String sql = "DELETE FROM Todo WHERE todo_id = ?";
        jdbcTemplate.update(sql, todoId);
    }

    // 다수의 할일 삭제
    public void deleteMultipleTodosByIds(List<Integer> todoIds) {
        if (todoIds == null || todoIds.isEmpty()) {
            throw new IllegalArgumentException("삭제할 todoId 리스트가 비어 있습니다.");
        }
        String placeholders = String.join(",", todoIds.stream().map(id -> "?").toArray(String[]::new));
        String sql = "DELETE FROM Todo WHERE todo_id IN (" + placeholders + ")";
        jdbcTemplate.update(sql, todoIds.toArray());
    }

    // 할일 진행률 업데이트
    public void updateTodoProgress(int todoId, int progress) {
        String sql = "UPDATE Todo SET progress = ? WHERE todo_id = ?";
        jdbcTemplate.update(sql, progress, todoId);
    }

    // 특정 프로젝트의 진행률 계산
    public int calculateProjectProgress(int projectNo) {
        String sql = "SELECT COALESCE(AVG(progress), 0) FROM Todo WHERE project_no = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, projectNo);
    }
}
