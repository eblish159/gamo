package fs.four.gamo.board.controller;

import fs.four.gamo.board.service.BoardService;
import fs.four.gamo.board.vo.BoardVO;
import fs.four.gamo.member.vo.LoginVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @RequestMapping(value= "/board", method = RequestMethod.GET)
    public String listBoards(Model model) throws Exception {
        List<BoardVO> boardList = boardService.listBoards();
        model.addAttribute("pageTitle", "게시판");
        model.addAttribute("contentPage", "/boardall/boardMain");
        model.addAttribute("boardList", boardList);

        return "layout";
    }

    @GetMapping("/board/{id}")
    public String boardPage(@PathVariable Long board_no, Model model, HttpSession session) {
        BoardVO boardVO = boardService.boardPage(board_no);
        LoginVO member = (LoginVO) session.getAttribute("member_id");

        boolean isOwner = member != null && boardVO.getMember_id().equals(member.getMember_id());
        boolean isAdmin = member != null && 0 == member.getRole();

        model.addAttribute("boardVO", boardVO);
        model.addAttribute("contentPage", "/boardall/boardPage");
        model.addAttribute("isEditable", isOwner || isAdmin);
        return "layout";
    }

//    @GetMapping("/board/boardWrite")
//    public String boardWrite(Model model) {
//        model.addAttribute("pageTitle", "게시판");
//        model.addAttribute("message", "게시판 글 작성 페이지");
//        model.addAttribute("contentPage", "boardall/boardWrite");
//        return "layout";
//    }

    @GetMapping("/board/boardWrite")
    public String boardWrite(HttpSession session, Model model) {
        model.addAttribute("pageTitle", "게시판");
        model.addAttribute("message", "게시판 글 작성 페이지");
        model.addAttribute("contentPage", "boardall/boardWrite");
        return "layout";
    }

    @PostMapping("/board/boardWrite")
    public String boardWrite(@ModelAttribute BoardVO boardVO, HttpSession session, Model model) {
        LoginVO member_Id = (LoginVO) session.getAttribute("member_Id");
        boardVO.setMember_id(member_Id.getMember_id());
        boardService.boardWrite(boardVO);
        return "redirect:/board";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long board_no, Model model, HttpSession session) {
        BoardVO boardVO = boardService.boardPage(board_no);
        LoginVO member = (LoginVO) session.getAttribute("member_id");

        if (!boardVO.getMember_id().equals(member.getMember_id()) && 0 != member.getRole()) {
            return "redirect:/board";
        }
        model.addAttribute("contentPage", "boardall/boardWrite");
        model.addAttribute("boardVO", boardVO);
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String updateBoard(@PathVariable Long board_no, @ModelAttribute BoardVO boardVO, HttpSession session) {
        LoginVO member = (LoginVO) session.getAttribute("member_id");

        if (!boardVO.getMember_id().equals(member.getMember_id()) && 0 !=member.getRole()) {
            return "redirect:/board";
        }

        boardVO.setBoard_no(board_no);
        boardService.boardUpdate(boardVO);
        return "redirect:/board";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long board_id, HttpSession session) {
        LoginVO member = (LoginVO) session.getAttribute("member_id");
        BoardVO boardVO = boardService.boardPage(board_id);

        if (!boardVO.getMember_id().equals(member.getMember_id()) && 0 != (member.getRole())) {
            return "redirect:/board";
        }

        boardService.boardDelete(board_id);
        return "redirect:/board";
    }

}