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
}