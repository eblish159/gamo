package fs.four.gamo.project.controller;

import fs.four.gamo.project.service.ProjectService;
import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // 프로젝트 리스트 페이지
    @GetMapping("/project")
    public String project(Model model) {
        ProjectVO project = projectService.getProjectDetails();
        model.addAttribute("pageTitle", "프로젝트");
        model.addAttribute("message", "프로젝트 리스트 페이지");
        model.addAttribute("contentPage", "projectall/projects");
        model.addAttribute("project", project);
        return "layout";
    }

    // 프로젝트 상세 페이지
    @GetMapping("/projectsdetail")
    public String projectsdetail(Model model) {
        ProjectVO project = projectService.getProjectDetails();
        model.addAttribute("pageTitle", "프로젝트 상세");
        model.addAttribute("message", "프로젝트 상세 페이지");
        model.addAttribute("contentPage", "projectall/projectsdetail");
        model.addAttribute("project", project);
        return "layout";
    }

    // 프로젝트 작성 페이지
    @GetMapping("/projectswrite")
    public String projectwrite(Model model) {
        model.addAttribute("pageTitle", "프로젝트 작성");
        model.addAttribute("message", "프로젝트 작성 페이지");
        model.addAttribute("contentPage", "projectall/projectswrite");
        return "layout";
    }

    // 프로젝트 저장 (새로운 프로젝트를 저장하는 메서드)
    @PostMapping("/projects/save")
    public String saveProject(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("start_date") String startDate,
            @RequestParam("end_date") String endDate,
            Model model) {

        if (title == null || title.isEmpty() || content == null || content.isEmpty()) {
            model.addAttribute("error", "제목과 내용은 필수 항목입니다.");
            model.addAttribute("contentPage", "projectall/projectswrite");
            return "layout"; // 작성 페이지로 리턴
        }

        ProjectVO project = new ProjectVO();
        project.setProjectTitle(title);
        project.setProjectContent(content);
        project.setStartDate(java.sql.Date.valueOf(startDate));
        project.setEndDate(java.sql.Date.valueOf(endDate));
        project.setProjectProgress(0); // progress 값을 0으로 설정

        projectService.saveProjectWithDates(project); // 날짜 포함 저장 메서드 호출

        model.addAttribute("message", "프로젝트가 성공적으로 저장되었습니다.");
        model.addAttribute("contentPage", "projectall/projects");
        return "layout";
    }

    // 종료된 프로젝트 상세 페이지
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
