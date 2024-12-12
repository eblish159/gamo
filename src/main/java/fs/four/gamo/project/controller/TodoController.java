package fs.four.gamo.project.controller;

import fs.four.gamo.project.service.TodoService;
import fs.four.gamo.project.vo.TodoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    // 할일 저장
    @PostMapping("/save")
    public String saveTodo(@RequestParam("projectNo") int projectNo,
                           @RequestParam("description") String description,
                           @RequestParam("userName") String userName) {
        logger.info("saveTodo 호출됨");
        logger.info("받은 데이터: projectNo={}, description={}, userName={} ", projectNo, description, userName);

        try {
            TodoVO todo = new TodoVO();
            todo.setProjectNo(projectNo);
            todo.setDescription(description);
            todo.setTodoName(userName); // userName 값을 TODO_NAME 컬럼에 저장
            todo.setProgress(0); // 초기 진행률 설정

            todoService.saveTodo(todo);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("할일 저장 중 오류 발생: ", e);
            return "FAILURE";
        }
    }

    // 특정 프로젝트의 할일 목록 조회
    @GetMapping("/list")
    public List<TodoVO> getTodoList(@RequestParam("projectNo") int projectNo) {
        logger.info("getTodoList 호출됨: projectNo={} ", projectNo);

        try {
            return todoService.getTodoListByProject(projectNo);
        } catch (Exception e) {
            logger.error("할일 목록 조회 중 오류 발생: ", e);
            return null;
        }
    }

    // 특정 할일 삭제
    @PostMapping("/delete")
    public String deleteTodo(@RequestParam("todoId") int todoId) {
        logger.info("deleteTodo 호출됨: todoId={} ", todoId);

        try {
            todoService.deleteTodoById(todoId);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("할일 삭제 중 오류 발생: ", e);
            return "FAILURE";
        }
    }

    // 여러 할일 삭제 (여러 ID를 한번에 처리)
    @PostMapping("/deleteMultiple")
    public String deleteMultipleTodos(@RequestBody List<Integer> todoIds) {
        logger.info("deleteMultipleTodos 호출됨: todoIds={} ", todoIds);

        try {
            for (int todoId : todoIds) {
                todoService.deleteTodoById(todoId);
            }
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("여러 할일 삭제 중 오류 발생: ", e);
            return "FAILURE";
        }
    }

    // 할일 진행률 업데이트
    @PostMapping("/updateProgress")
    public String updateTodoProgress(@RequestParam("todoId") int todoId,
                                     @RequestParam("progress") int progress) {
        logger.info("updateTodoProgress 호출됨: todoId={}, progress={} ", todoId, progress);

        try {
            todoService.updateTodoProgress(todoId, progress);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("할일 진행률 업데이트 중 오류 발생: ", e);
            return "FAILURE";
        }
    }
}
