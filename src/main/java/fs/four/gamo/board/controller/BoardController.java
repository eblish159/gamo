package fs.four.gamo.board.controller;

import fs.four.gamo.board.service.BoardService;
import fs.four.gamo.board.vo.BoardVO;
import fs.four.gamo.member.vo.LoginVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String listBoards(@RequestParam(value = "page", defaultValue = "1") int currentPage, Model model) throws Exception {
        int boardSize = 10;
        int boardCount = boardService.boardCount();
        int totalPages = (int) Math.ceil((double) boardCount / boardSize);

        if (currentPage < 1) {
            currentPage = 1;
        } else if (currentPage > totalPages) {
            currentPage = totalPages;
        }

        int boardStart = (currentPage - 1) * boardSize;
        int boardEnd = Math.min(boardStart + boardSize, boardCount);
        List<BoardVO> boardPage= boardService.listBoards().subList(boardStart, boardEnd);

        model.addAttribute("pageTitle", "게시판");
        model.addAttribute("contentPage", "/boardall/boardMain");
        model.addAttribute("boardPage", boardPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);

        System.out.println("글 갯수!!!!!" + boardCount);
        return "layout";
    }

    @GetMapping("/board/{board_no}")
    public String boardPage(@PathVariable("board_no") Long board_no, Model model, HttpSession session) {
        BoardVO board = boardService.boardPage(board_no);
        LoginVO member = (LoginVO) session.getAttribute("loginVO");

        boolean isOwner = member != null && board.getMember_id().equals(member.getMember_id());
        boolean isAdmin = member != null && member.getRole() == 0;

        model.addAttribute("board", board);
        model.addAttribute("contentPage", "/boardall/boardView");
        model.addAttribute("isEditable", isOwner || isAdmin);
        return "layout";
    }

    @GetMapping("/board/boardWrite")
    public String boardForm(HttpSession session, Model model) {
        LoginVO member = (LoginVO) session.getAttribute("loginVO");
        System.out.println("get /board/boardWrite loginVO: " + member);
        model.addAttribute("pageTitle", "게시판");
        model.addAttribute("message", "게시판 글 작성 페이지");
        model.addAttribute("contentPage", "boardall/boardWrite");
        System.out.println("boardForm GET()에서 세션 사용자: " + member);
        return "layout";
    }

    @PostMapping("/board/boardWrite")
    public String boardWrite(@ModelAttribute BoardVO board, HttpSession session) {
        LoginVO member = (LoginVO) session.getAttribute("loginVO");

        if (member != null) {
            board.setMember_id(member.getMember_id());
        }
        System.out.println("boardWrite POST()에서 세션 사용자: " + member);
        boardService.boardWrite(board);
        return "redirect:/board";
    }

    @GetMapping("/board/update/{board_no}")
    public String updateForm(@PathVariable("board_no") Long board_no, Model model, HttpSession session) {
        BoardVO board = boardService.boardPage(board_no);
        LoginVO member = (LoginVO) session.getAttribute("loginVO");

        if (board == null || (!board.getMember_id().equals(member.getMember_id()) && member.getRole() != 0)) {
            return "redirect:/board";
        }

        model.addAttribute("board", board);
        model.addAttribute("contentPage", "boardall/boardWrite");
        System.out.println("updateForm GET()에서 세션 사용자: " + board);
        return "layout";
    }

    @PostMapping("/board/update/{board_no}")
    public String updateBoard(@PathVariable("board_no") Long board_no, @ModelAttribute BoardVO board_update, HttpSession session) {
        BoardVO board = boardService.boardPage(board_no);
        LoginVO member = (LoginVO) session.getAttribute("loginVO");

        if (member == null || !board.getMember_id().equals(member.getMember_id()) || member.getRole() != 0) {
            return "redirect:/board";
        }

        System.out.println("updateBoard POST()에서 세션 사용자: " + board_update);
        boardService.boardUpdate(board_update);

        return "redirect:/board/{board_no}";
    }

    @PostMapping("/board/delete/{board_no}")
    public String deletePost(@PathVariable("board_no") Long board_no, HttpSession session) {
        LoginVO member = (LoginVO) session.getAttribute("loginVO");
        BoardVO board = boardService.boardPage(board_no);

        if (!board.getMember_id().equals(member.getMember_id()) && member.getRole() != 0) {
            return "redirect:/board";
        }

        boardService.boardDelete(board_no);
        return "redirect:/board";
    }
}