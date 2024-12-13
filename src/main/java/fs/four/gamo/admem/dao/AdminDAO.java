package fs.four.gamo.admem.dao;

import fs.four.gamo.member.vo.LoginVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDAO {
    List<LoginVO> findAllMember();
    void addMember(LoginVO loginVO);
    void delMember(String member_id);
}
