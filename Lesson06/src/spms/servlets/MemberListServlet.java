package spms.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import spms.dao.MemberDao;

@WebServlet("/member/list")
public class MemberListServlet extends GenericServlet {
	private static final long SerialVersionUID = 1L;
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			
			request.setAttribute("members", memberDao.selectList());
			
			request.setAttribute("viewUrl", "/member/MemberList.jsp");
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
