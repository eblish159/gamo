package fs.four.gamo.board.controller;

import fs.four.gamo.board.service.BoardService;
import fs.four.gamo.board.vo.BoardVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("pageTitle", "게시판");
        model.addAttribute("message", "게시판 목록 페이지입니다.");
        model.addAttribute("contentPage", "boardall/boardMain");
        return "layout";
    }

    @GetMapping("/board/boardWrite")
    public String boardWrite(Model model) {
        model.addAttribute("pageTitle", "게시판");
        model.addAttribute("message", "게시판 글 작성 페이지");
        model.addAttribute("contentPage", "boardall/boardWrite");
        return "layout";
    }

    @RequestMapping(value= "/board/boardtest", method = RequestMethod.GET)
    public ModelAndView listBoards(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<BoardVO> boardList = boardService.listBoards();
        ModelAndView mav = new ModelAndView("/boardall/boardTest");
        mav.addObject("boardList", boardList);

        System.out.println("Board List: " + (boardList != null ? boardList.toString() : "No Data"));

        return mav;
    }
}