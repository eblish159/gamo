package fs.four.gamo.board.dao;

import fs.four.gamo.board.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface BoardDAO {
    public List<BoardVO> getList() throws DataAccessException;
    public BoardVO getByBoardNo(Long Board_No)throws DataAccessException;
    public void boardInsert(BoardVO boardVO)throws DataAccessException;
    public void boardUpdate(BoardVO boardVO)throws DataAccessException;
    public void boardDelete(Long Board_No)throws DataAccessException;
    public int boardCount()throws DataAccessException;
}
