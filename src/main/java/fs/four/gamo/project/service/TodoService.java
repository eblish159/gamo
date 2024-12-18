package fs.four.gamo.project.service;

import fs.four.gamo.project.dao.TodoDAO;
import fs.four.gamo.project.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class TodoService {

    private static final Logger logger = LoggerFactory.getLogger(TodoService.class);

    @Autowired
    private TodoDAO todoDAO;

    // 할일 저장
    public void saveTodo(TodoVO todo) {
        try {
            todoDAO.saveTodo(todo);
            logger.info("할일 저장 완료: {}", todo);
        } catch (Exception e) {
            logger.error("할일 저장 실패: {}", todo, e);
            throw e;
        }
    }

    // 특정 프로젝트의 할일 목록 조회
    public List<TodoVO> getTodoListByProject(int projectNo) {
        try {
            List<TodoVO> todoList = todoDAO.getTodoListByProject(projectNo);
            logger.info("프로젝트 {}의 할일 목록 조회 완료. 항목 수: {}", projectNo, todoList.size());
            return todoList;
        } catch (Exception e) {
            logger.error("프로젝트 {}의 할일 목록 조회 실패", projectNo, e);
            throw e;
        }
    }

    // 특정 할일 삭제
    public void deleteTodoById(int todoId) {
        try {
            todoDAO.deleteTodoById(todoId);
            logger.info("할일 삭제 완료. ID: {}", todoId);
        } catch (Exception e) {
            logger.error("할일 삭제 실패. ID: {}", todoId, e);
            throw e;
        }
    }

    // 다수의 할일 삭제
    public void deleteMultipleTodosByIds(List<Integer> todoIds) {
        try {
            for (int todoId : todoIds) {
                todoDAO.deleteTodoById(todoId);
                logger.info("할일 삭제 완료. ID: {}", todoId);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    // 특정 할일의 진행률 업데이트
    public void updateTodoProgress(int todoId, int progress) {
        try {
            todoDAO.updateTodoProgress(todoId, progress);
        } catch (Exception e) {
            throw e;
        }
    }

    // 프로젝트 진행률 계산
    public int calculateProjectProgress(int projectNo) {
        try {
            List<TodoVO> todos = todoDAO.getTodoListByProject(projectNo);
            if (todos.isEmpty()) {
                return 0; // 할일이 없으면 진행률 0%
            }

            int totalProgress = todos.stream().mapToInt(TodoVO::getProgress).sum();
            int averageProgress = totalProgress / todos.size();

            logger.info("프로젝트 {}의 평균 진행률 계산 완료: {}%", projectNo, averageProgress);
            return averageProgress;
        } catch (Exception e) {
            throw new RuntimeException("프로젝트 진행률 계산 중 오류 발생", e);
        }
    }
}
