package fs.four.gamo.member.controller;

import fs.four.gamo.member.service.LoginService;
import fs.four.gamo.member.vo.LoginVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginVO loginVO;

    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("member_id") LoginVO member_id,
                              RedirectAttributes rAttr,
                              HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        loginVO = loginService.login(member_id);

        if (loginVO != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginVO", loginVO);
            session.setAttribute("isLogOn", true);

            session.setAttribute("member_id", loginVO.getMember_id());

            String action = (String) session.getAttribute("action");
            session.removeAttribute("action");

            if (action != null) {
                mav.setViewName("redirect:" + action);
            } else {
                mav.setViewName("redirect:/");
            }
        } else {
            rAttr.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다!!");
            mav.setViewName("redirect:/login");
        }

        return mav;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/member/login");
        return mav;
    }
}

