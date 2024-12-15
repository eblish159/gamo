package fs.four.gamo.admem.service;

import fs.four.gamo.admem.dao.AdminDAO;
import fs.four.gamo.member.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminDAO adminDAO;

    public List<LoginVO> listMembers() {
        return adminDAO.findAllMember();
    }

    public List<LoginVO> searchMembers(String searchKeyword, String searchCondition) {
        return adminDAO.searchMembers(searchKeyword, searchCondition);
    }

    public void addMember(LoginVO loginVO) {
        adminDAO.addMember(loginVO);
    }

    public void delMember(String member_id) {
        adminDAO.delMember(member_id);
    }
}
