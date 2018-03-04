package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.dao.MySqlMemberDao;

@Component("/member/list.do")
public class MemberListController implements Controller {
	MySqlMemberDao memberDao;
	  
	public MemberListController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		// Map 객체에서 MemberDao를 꺼낸다.
//	    MemberDao memberDao = (MemberDao)model.get("memberDao");
	    
	    // 회원 목록 데이터를 Map 객체에 저장한다.
	    model.put("members", memberDao.selectList());
	    
	    // 화면을 출력할 페이지의 URL을 반환한다.
	    return "/member/MemberList.jsp";
	}
}
