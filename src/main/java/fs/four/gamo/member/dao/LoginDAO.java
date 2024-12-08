package fs.four.gamo.member.dao;

import fs.four.gamo.member.vo.LoginVO;

@Mapper
public interface LoginDAO {
    public LoginVO login(LoginVO loginVO);
}
