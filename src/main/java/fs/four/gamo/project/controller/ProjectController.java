package fs.four.gamo.project.controller;

import fs.four.gamo.project.service.ProjectService;
import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    //매핑 뭐로할지 주소입력이걸로
    public String project(Model model) {
        ProjectVO project = projectService.getProjectDetails();
        model.addAttribute("pageTitle", "프로젝트"); // 페이지 제목 설정
        model.addAttribute("message", "프로젝트 리스트 페이지"); // 메시지 설정
        model.addAttribute("contentPage", "projectall/projects"); // contentPage 값을 설정 (projectall/projects.jsp 파일을 포함)
        model.addAttribute("project", project); // 데이터 모델에 추가하여 JSP에서 사용
        return "layout"; // layout.jsp를 반환 (layout.jsp에서 contentPage를 사용하여 동적 포함)
    }

    @GetMapping("/projectsdetail")
    //매핑 뭐로할지 주소입력이걸로
    public String projectsdetail(Model model) {
        ProjectVO project = projectService.getProjectDetails();
        model.addAttribute("pageTitle", "프로젝트상세"); // 페이지 제목 설정
        model.addAttribute("message", "프로젝트 상세 페이지"); // 메시지 설정
        model.addAttribute("contentPage", "projectall/projectsdetail"); // contentPage 값을 설정 (projectall/projects.jsp 파일을 포함)
        model.addAttribute("project", project); // 데이터 모델에 추가하여 JSP에서 사용
        return "layout"; // layout.jsp를 반환 (layout.jsp에서 contentPage를 사용하여 동적 포함)
    }

    @GetMapping("/endprojects")
    //매핑 뭐로할지 주소입력이걸로
    public String endprojects(Model model) {
        ProjectVO project = projectService.getProjectDetails();
        model.addAttribute("pageTitle", "프로젝트상세"); // 페이지 제목 설정
        model.addAttribute("message", "프로젝트 상세 페이지"); // 메시지 설정
        model.addAttribute("contentPage", "projectall/endprojects"); // contentPage 값을 설정 (projectall/projects.jsp 파일을 포함)
        model.addAttribute("project", project); // 데이터 모델에 추가하여 JSP에서 사용
        return "layout"; // layout.jsp를 반환 (layout.jsp에서 contentPage를 사용하여 동적 포함)
    }
}
