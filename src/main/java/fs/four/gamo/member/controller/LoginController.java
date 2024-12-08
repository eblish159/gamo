package fs.four.gamo.member.controller;

import fs.four.gamo.member.service.LoginService;
import fs.four.gamo.member.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String loginPage() {
        return "test";
    }

    @PostMapping("/login")
    public String login(LoginVO loginVO, Model model) {
        LoginVO loginCheck = loginService.login(loginVO);
        if (loginCheck != null) {
            model.addAttribute("user", loginCheck);
            return "member/result";
        } else {
            model.addAttribute("error", "로그인 실패");
            return "member/test1";
        }
    }
}


