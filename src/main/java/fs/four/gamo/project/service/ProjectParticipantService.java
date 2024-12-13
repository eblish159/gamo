package fs.four.gamo.project.service;


import fs.four.gamo.project.dao.ProjectParticipantDAO;
import fs.four.gamo.project.vo.ProjectParticipantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectParticipantService {

    @Autowired
    private ProjectParticipantDAO participantDAO;

    public void addParticipant(ProjectParticipantVO participant) {
        participantDAO.insertParticipant(participant);
    }

    public List<ProjectParticipantVO> getParticipants(int projectNo) {
        return participantDAO.selectParticipantsByProjectNo(projectNo);
    }
}
