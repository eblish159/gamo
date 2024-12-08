package fs.four.gamo.project.service;

import fs.four.gamo.project.dao.ProjectDAO;
import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectDAO projectDAO; // DAO 의존성 주입

    public ProjectVO getProjectDetails() {
        return projectDAO.getProjectDetails(); // DAO에서 데이터 가져오기
    }
}
