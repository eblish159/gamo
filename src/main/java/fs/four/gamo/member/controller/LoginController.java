package fs.four.gamo.member.controller;

import fs.four.gamo.member.service.LoginService;
import fs.four.gamo.member.vo.LoginVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ModelAndView login(@ModelAttribute("member") LoginVO member,
                              RedirectAttributes rAttr,
                              HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        loginVO = loginService.login(member);

        if (loginVO != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginVO", loginVO);
            session.setAttribute("isLogOn", true);

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
        session.removeAttribute("loginVO");
        session.setAttribute("isLogOn", false);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/member/login");
        return mav;
    }
}