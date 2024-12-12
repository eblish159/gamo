package fs.four.gamo.admem.controller;

import fs.four.gamo.admem.service.AdminService;
import fs.four.gamo.member.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public String listMembers(Model model) {
        List<LoginVO> members = adminService.listMembers();
        model.addAttribute("members", members);
        model.addAttribute("contentPage", "admemall/admemmain");
        return "layout";
    }

    @PostMapping("/addMember")
    public String addMember(@ModelAttribute LoginVO loginVO) {
        adminService.addMember(loginVO);
        return "redirect:/admin";
    }

    @PostMapping("/delMember")
    public String deleteMember(@RequestParam("member_id") String member_id) {
        System.out.println("삭제 요청 받은 ID: " + member_id);
        adminService.delMember(member_id);
        return "redirect:/admin";
    }
}