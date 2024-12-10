package fs.four.gamo.project.controller;

import fs.four.gamo.project.service.ProjectService;
import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    public String project(Model model) {
        ProjectVO project = projectService.getProjectDetails();
        model.addAttribute("pageTitle", "프로젝트");
        model.addAttribute("message", "프로젝트 리스트 페이지");
        model.addAttribute("contentPage", "projectall/projects");
        model.addAttribute("project", project);
        return "layout";
    }

    @GetMapping("/projectsdetail")
    public String projectsdetail(Model model) {
        ProjectVO project = projectService.getProjectDetails();
        model.addAttribute("pageTitle", "프로젝트 상세");
        model.addAttribute("message", "프로젝트 상세 페이지");
        model.addAttribute("contentPage", "projectall/projectsdetail");
        model.addAttribute("project", project);
        return "layout";
    }

    @GetMapping("/projectswrite")
    public String projectwrite(Model model) {
        ProjectVO project = projectService.getProjectDetails();
        model.addAttribute("pageTitle", "프로젝트 작성");
        model.addAttribute("message", "프로젝트 작성 페이지");
        model.addAttribute("contentPage", "projectall/projectswrite");
        model.addAttribute("project", project);
        return "layout";
    }

    @PostMapping("/projects/save")
    public String saveProject(
            @RequestParam("title") String title,
            @RequestParam("content") String content,

            Model model) {



        if (title == null || content == null) {
            model.addAttribute("error", "제목과 내용은 필수 항목입니다.");
            return "projectswrite"; // 작성 페이지로 리턴
        }

        ProjectVO project = new ProjectVO();

        project.setProjectTitle(title);
        project.setProjectContent(content);


        projectService.saveProject(project);

        model.addAttribute("message", "프로젝트가 성공적으로 저장되었습니다.");
        model.addAttribute("contentPage", "projectall/projects");
        return "layout";
    }

    @GetMapping("/endprojects")
    public String endprojects(Model model) {
        ProjectVO project = projectService.getProjectDetails();
        model.addAttribute("pageTitle", "프로젝트 종료");
        model.addAttribute("message", "종료된 프로젝트 상세 페이지");
        model.addAttribute("contentPage", "projectall/endprojects");
        model.addAttribute("project", project);
        return "layout";
    }
}
