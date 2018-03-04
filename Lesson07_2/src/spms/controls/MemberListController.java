package spms.controls;

import java.util.HashMap;
import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MySqlMemberDao;

@Component("/member/list.do")
public class MemberListController implements Controller, DataBinding {
	MySqlMemberDao memberDao;
	  
	public MemberListController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[]{
		        "orderCond", String.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
	  	paramMap.put("orderCond", model.get("orderCond"));
	  	
	    model.put("members", memberDao.selectList(paramMap));
	    return "/member/MemberList.jsp";
	}
}
