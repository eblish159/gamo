package fs.four.gamo.project.controller;

import fs.four.gamo.project.service.TodoService;
import fs.four.gamo.project.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("todoControllerForProject")
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // 할일 저장
    @PostMapping("/save")
    @ResponseBody
    public String saveTodo(@RequestParam("projectNo") int projectNo,
                           @RequestParam("description") String description,
                           @RequestParam("userName") String userName) {
        TodoVO todo = new TodoVO();
        todo.setProjectNo(projectNo);
        todo.setDescription(description);
        todo.setMemberId(userName);
        todo.setProgress(0); // 초기 진행률 설정

        todoService.saveTodo(todo);
        return "SUCCESS";
    }

    // 특정 프로젝트의 할일 목록 조회
    @GetMapping("/list")
    @ResponseBody
    public List<TodoVO> getTodoList(@RequestParam("projectNo") int projectNo) {
        return todoService.getTodoListByProject(projectNo);
    }
}
