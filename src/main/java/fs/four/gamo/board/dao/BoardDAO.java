package fs.four.gamo.board.dao;

import fs.four.gamo.board.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface BoardDAO {
    List<BoardVO> showList() throws DataAccessException;
}
