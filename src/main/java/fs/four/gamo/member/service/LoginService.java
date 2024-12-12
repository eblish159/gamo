package fs.four.gamo.member.service;

import fs.four.gamo.member.dao.LoginDAO;
import fs.four.gamo.member.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginDAO loginDAO;

    public LoginVO login(LoginVO loginVO) throws Exception{
        return loginDAO.loginById(loginVO);
    }
}
