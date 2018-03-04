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

import spms.dao.MemberDao;

/**
 * Servlet implementation class MemberDeleteDervlet
 */
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			
//			Connection conn = (Connection) sc.getAttribute("conn");
//			MemberDao memberDao = new MemberDao();
//			memberDao.setConnection(conn);

			memberDao.delete(Integer.parseInt(request.getParameter("no")));

			response.sendRedirect("list");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}

//		Connection conn = null;
//		Statement stmt = null;
//
//		try {
//			ServletContext sc = this.getServletContext();
//			Class.forName(sc.getInitParameter("driver"));
//			conn = DriverManager.getConnection(
//						sc.getInitParameter("url"),
//						sc.getInitParameter("username"),
//						sc.getInitParameter("password")); 
//			stmt = conn.createStatement();
//			stmt.executeUpdate(
//					"DELETE FROM MEMBERS WHERE MNO=" + 
//					request.getParameter("no"));
//			
//			response.sendRedirect("list");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("error", e);
//			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
//			rd.forward(request, response);
//		} finally {
//			try {if (stmt != null) stmt.close();} catch(Exception e) {}
//			try {if (conn != null) conn.close();} catch(Exception e) {}
//		}
	}
}
