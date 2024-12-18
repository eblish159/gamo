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

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
            session.setAttribute("member_id", loginVO.getMember_id()); // 개별 필드 저장
            session.setAttribute("name", loginVO.getName()); // 개별 필드 저장
            session.setAttribute("isLogOn", true);
            System.out.println("로그인 성공 - member_id: " + loginVO.getMember_id());
            System.out.println("로그인 성공 - name: " + loginVO.getName());
            System.out.println("로그인 성공 - gameonoff: " + loginVO.getGameonoff());

            session.setAttribute("member_id", loginVO.getMember_id());

            String action = (String) session.getAttribute("action");
            session.removeAttribute("action");

            if ("y".equalsIgnoreCase(loginVO.getGameonoff())) {
                String[] pages = {"/game1", "/game2"};
                String randomPage = pages[new Random().nextInt(pages.length)];
                mav.setViewName("redirect:" + randomPage); // 랜덤 페이지로 리다이렉트
            } else {
                mav.setViewName("redirect:/"); // 메인 페이지로 리다이렉트
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

        if (session != null) {
            session.invalidate();
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/login");
        return mav;
    }

    // 로그인된 회원 세션 정보 반환
    @GetMapping("/member/session")
    @ResponseBody
    public Map<String, String> getMemberSession(HttpSession session) {
        LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");

        Map<String, String> response = new HashMap<>();
        if (loginVO != null) {
            System.out.println("API 호출 - member_id: " + loginVO.getMember_id());
            System.out.println("API 호출 - name: " + loginVO.getName());

            response.put("member_id", loginVO.getMember_id());
            response.put("name", loginVO.getName());
        } else {
            response.put("error", "세션 정보가 없습니다.");
        }
        return response;
    }

    @GetMapping("/game1")
    public String loginGame1() {
        return "/member/game1";
    }

    @GetMapping("/game2")
    public String loginGame2() {
        return "member/game2";
    }


}


