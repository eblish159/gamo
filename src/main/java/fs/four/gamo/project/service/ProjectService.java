package fs.four.gamo.project.service;

import fs.four.gamo.project.dao.ProjectDAO;
import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    // 기존 메서드: 프로젝트 상세 정보를 가져오는 메서드
    public ProjectVO getProjectDetails() {
        return projectDAO.getProjectDetails(1); // 예제용 project_no 하드코딩 (필요 시 변경 가능)
    }

    // 기존 메서드: 프로젝트를 저장하는 메서드
    public void saveProject(ProjectVO project) {
        projectDAO.insertProject(project);
    }

    // 추가된 메서드: 프로젝트를 날짜 포함 저장하는 메서드
    public void saveProjectWithDates(ProjectVO project) {
        projectDAO.saveProjectWithDates(project);
    }
}
