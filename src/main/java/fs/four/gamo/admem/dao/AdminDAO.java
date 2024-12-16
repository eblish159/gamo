package fs.four.gamo.admem.dao;

import fs.four.gamo.member.vo.LoginVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface AdminDAO {
    public List<LoginVO> findAllMember() throws DataAccessException;
    public void addMember(LoginVO loginVO) throws DataAccessException;
    public void delMember(String member_id) throws DataAccessException;
    public int memberCount() throws DataAccessException;
}
