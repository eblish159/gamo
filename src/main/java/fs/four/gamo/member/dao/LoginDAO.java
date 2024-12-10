package fs.four.gamo.member.dao;

import fs.four.gamo.member.vo.LoginVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.Map;

@Mapper
public interface LoginDAO {
    public LoginVO loginById(LoginVO loginVO) throws DataAccessException;
}
