package fs.four.gamo.admem.dao;

import fs.four.gamo.member.vo.LoginVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminDAO {
    public List<LoginVO> findAllMember();
    public List<LoginVO> searchMembers(@Param("searchKeyword") String searchKeyword,
                                       @Param("searchCondition") String searchCondition);
    public void addMember(LoginVO loginVO);
    public void delMember(String member_id);
}
