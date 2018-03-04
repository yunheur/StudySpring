package spms.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;
import spms.vo.Member;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/auth/login")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("viewUrl", "/auth/LogInForm.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			Member member = memberDao.exist(
					request.getParameter("email"), 
					request.getParameter("password"));
			if (member != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				request.setAttribute("viewUrl", "redirect:../member/list.do");
			} else {
				 request.setAttribute("viewUrl", "/auth/LogInFail.jsp");
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
