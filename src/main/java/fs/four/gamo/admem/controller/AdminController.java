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
    public String listMembers(@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
                              @RequestParam(value = "searchCondition", required = false) String searchCondition,
                              Model model) {

        List<LoginVO> members;

        if (searchKeyword != null && !searchKeyword.isEmpty() && searchCondition != null) {
            members = adminService.searchMembers(searchKeyword, searchCondition);
        } else {
            members = adminService.listMembers();
        }

        model.addAttribute("members", members);
        model.addAttribute("contentPage", "admemall/admemmain");
        return "layout";
    }

    @PostMapping("/admin/addMember")
    public String addMember(@ModelAttribute LoginVO loginVO) {
        adminService.addMember(loginVO);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delMember")
    public String deleteMember(@RequestParam("id") String member_id, Model model) {
        adminService.delMember(member_id);
        return "redirect:/admin";
    }
}