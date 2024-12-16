package fs.four.gamo.admem.controller;

import fs.four.gamo.admem.service.AdminService;
import fs.four.gamo.board.vo.BoardVO;
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
    public String listMembers(@RequestParam(value = "page", defaultValue = "1") int currentPage, Model model)  throws Exception {
        int memberSize = 10;
        int memberCount = adminService.memberCount();
        int totalPages = (int) Math.ceil((double) memberCount / memberSize);

        if (currentPage < 1) {
            currentPage = 1;
        } else if (currentPage > totalPages) {
            currentPage = totalPages;
        }

        int memberStart = (currentPage - 1) * memberSize;
        int memberEnd = Math.min(memberStart + memberSize, memberCount);
        List<LoginVO> members= adminService.listMembers().subList(memberStart, memberEnd);
        model.addAttribute("contentPage", "admemall/admemmain");
        model.addAttribute("members", members);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);

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