package fs.four.gamo.project.service;

import fs.four.gamo.project.dao.ProjectDAO;
import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    // 모든 프로젝트를 가져오는 메서드
    public List<ProjectVO> getAllProjects() {
        return projectDAO.getAllProjects();
    }

    // 종료된 프로젝트(진행률 100%)만 가져오는 메서드
    public List<ProjectVO> getEndedProjects() {
        return projectDAO.getEndedProjects();
    }

    // 프로젝트 상세 정보를 가져오는 메서드 (기본 프로젝트 ID 사용)
    public ProjectVO getProjectDetails() {
        return projectDAO.getProjectDetails(1); // 예제용 project_no 하드코딩 (필요 시 변경 가능)
    }

    // 프로젝트 상세 정보를 프로젝트 번호로 가져오는 메서드
    public ProjectVO getProjectDetailsById(int projectNo) {
        return projectDAO.getProjectDetails(projectNo);
    }

    // 프로젝트를 기본 정보로 저장하는 메서드
    public void saveProject(ProjectVO project) {
        projectDAO.insertProject(project);
    }

    // 프로젝트를 날짜 포함 저장하는 메서드
    public void saveProjectWithDates(ProjectVO project) {
        projectDAO.saveProjectWithDates(project);
    }

    // 프로젝트 진행률 업데이트 메서드
    public void updateProjectProgress(int projectNo, int progress) {
        projectDAO.updateProgress(projectNo, progress);
    }

    // 프로젝트 삭제 메서드
    public boolean deleteProjectById(int projectNo) {
        int rowsAffected = projectDAO.deleteProjectById(projectNo);
        return rowsAffected > 0; // 삭제된 행이 1개 이상이면 true 반환, 아니면 false 반환
    }


}
