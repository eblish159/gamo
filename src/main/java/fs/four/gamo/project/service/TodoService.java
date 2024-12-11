package fs.four.gamo.project.service;

import fs.four.gamo.project.dao.TodoDAO;
import fs.four.gamo.project.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoDAO todoDAO;

    public void saveTodo(TodoVO todo) {
        todoDAO.saveTodo(todo);
    }

    public List<TodoVO> getTodoListByProject(int projectNo) {
        return todoDAO.getTodoListByProject(projectNo);
    }
}
