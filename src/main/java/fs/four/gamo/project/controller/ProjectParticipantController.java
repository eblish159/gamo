package fs.four.gamo.project.controller;

import fs.four.gamo.project.service.ProjectParticipantService;
import fs.four.gamo.project.vo.ProjectParticipantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/participants")
public class ProjectParticipantController {

    @Autowired
    private ProjectParticipantService participantService;

    // 참여자 추가 API
    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> addParticipant(@RequestBody ProjectParticipantVO participant) {
        Map<String, String> response = new HashMap<>();

        if (participant.getProjectNo() == 0 || participant.getMemberId() == null || participant.getMemberId().isEmpty()) {
            response.put("status", "FAILURE");
            response.put("message", "Invalid input data");
            return ResponseEntity.badRequest().body(response);
        }

        try {
            participantService.addParticipant(participant);
            response.put("status", "SUCCESS");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "FAILURE");
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    // 특정 프로젝트의 참여자 목록 조회 API
    @GetMapping("/{projectNo}")
    public ResponseEntity<List<ProjectParticipantVO>> getParticipants(@PathVariable int projectNo) {
        List<ProjectParticipantVO> participants = participantService.getParticipants(projectNo);
        return ResponseEntity.ok(participants);
    }
}
