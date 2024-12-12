package fs.four.gamo.project.controller;

import fs.four.gamo.project.service.ProjectService;
import fs.four.gamo.project.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // 프로젝트 리스트 페이지
    @GetMapping("/project")
    public String project(Model model) {
        model.addAttribute("pageTitle", "프로젝트");
        model.addAttribute("message", "프로젝트 리스트 페이지");
        model.addAttribute("contentPage", "projectall/projects");
        model.addAttribute("projectList", projectService.getAllProjects()); // 프로젝트 목록 추가
        return "layout";
    }

    // 프로젝트 상세 페이지
    @GetMapping("/projectsdetail")
    public String projectsdetail(@RequestParam(value = "projectNo", required = false) Integer projectNo, Model model) {
        ProjectVO project = (projectNo != null) ? projectService.getProjectDetailsById(projectNo) : projectService.getProjectDetails();
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

    // 프로젝트 저장
    @PostMapping("/projects/save")
    public String saveProject(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("start_date") String startDate,
            @RequestParam("end_date") String endDate,
            Model model) {

        if (title.isEmpty() || content.isEmpty()) {
            model.addAttribute("error", "제목과 내용은 필수 항목입니다.");
            model.addAttribute("contentPage", "projectall/projectswrite");
            return "layout";
        }

        ProjectVO project = new ProjectVO();
        project.setProjectTitle(title);
        project.setProjectContent(content);
        project.setStartDate(java.sql.Date.valueOf(startDate));
        project.setEndDate(java.sql.Date.valueOf(endDate));
        project.setProjectProgress(0);

        projectService.saveProjectWithDates(project);
        return "redirect:/project";
    }

    // 종료된 프로젝트 페이지
    @GetMapping("/endprojects")
    public String endprojects(Model model) {
        model.addAttribute("pageTitle", "종료된 프로젝트");
        model.addAttribute("message", "종료된 프로젝트 목록");
        model.addAttribute("contentPage", "projectall/endprojects");
        model.addAttribute("projectList", projectService.getEndedProjects());
        return "layout";
    }

    // 프로젝트 진행률 저장
    @PostMapping("/projects/saveProgress")
    public String saveProjectProgress(@RequestParam("projectNo") int projectNo, @RequestParam("progress") int progress) {
        projectService.updateProjectProgress(projectNo, progress);
        return "redirect:/projectsdetail?projectNo=" + projectNo;
    }

    // 프로젝트 삭제
    @PostMapping("/projects/delete")
    @ResponseBody
    public String deleteProject(@RequestParam("projectNo") int projectNo) {
        try {
            boolean isDeleted = projectService.deleteProjectById(projectNo);

            if (isDeleted) {
                System.out.println("프로젝트 삭제 성공: " + projectNo);
                return "SUCCESS"; // 성공 시 텍스트 응답
            } else {
                System.out.println("프로젝트 삭제 실패: " + projectNo);
                return "FAILURE"; // 실패 시 텍스트 응답
            }
        } catch (Exception e) {
            System.err.println("프로젝트 삭제 중 오류 발생: " + projectNo);
            e.printStackTrace();
            return "ERROR"; // 예외 발생 시 텍스트 응답
        }
    }
}
