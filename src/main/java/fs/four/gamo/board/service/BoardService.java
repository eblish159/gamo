package fs.four.gamo.board.service;

import fs.four.gamo.board.dao.BoardDAO;
import fs.four.gamo.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardDAO boardDAO;

    public List<BoardVO> listBoards() {
        List<BoardVO> boardList = null;
        boardList = boardDAO.getList();
        return boardList;
    }

    public BoardVO boardPage(Long Board_No) {
        return boardDAO.getByBoardNo(Board_No);
    }

    public void boardWrite(BoardVO boardVO) {
        boardDAO.boardInsert(boardVO);
    }

    public void boardUpdate(BoardVO boardVO) {
        boardDAO.boardUpdate(boardVO);
    }

    public void boardDelete(Long Board_No) {
        boardDAO.boardDelete(Board_No);
    }

    public int boardCount() throws Exception {
        return boardDAO.boardCount();
    }
}