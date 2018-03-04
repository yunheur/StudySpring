package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MySqlMemberDao;
import spms.vo.Member;

@Component("/member/add.do")
public class MemberAddController implements Controller, DataBinding {
	MySqlMemberDao memberDao;

	public MemberAddController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"member", spms.vo.Member.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		Member member = (Member) model.get("member");
		if (member.getEmail() == null) { // 입력폼을 요청할 때
			return "/member/MemberForm.jsp";

		} else { // 회원 등록을 요청할 때
//			MemberDao memberDao = (MemberDao) model.get("memberDao");
			memberDao.insert(member);

			return "redirect:list.do";
		}
	}


}
