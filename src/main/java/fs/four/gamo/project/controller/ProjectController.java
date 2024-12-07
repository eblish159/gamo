package fs.four.gamo.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    @GetMapping("/project")
    public String project(Model model) {
        model.addAttribute("pageTitle", "프로젝트리스트");
        return "projectall/projects"; // project.jsp를 반환
    }

}


