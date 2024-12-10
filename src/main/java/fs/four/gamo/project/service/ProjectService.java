package fs.four.gamo.project.service;

import fs.four.gamo.project.dao.ProjectDAO;
import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    public ProjectVO getProjectDetails() {
        return projectDAO.getProjectDetails();
    }

    public void saveProject(ProjectVO project) {
        projectDAO.insertProject(project);
    }
}
