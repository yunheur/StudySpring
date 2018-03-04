package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@SuppressWarnings("serial")
/* 애노테이션을 이용하여 서블릿 배치 정보 설정
 * - 서블릿 초기화 파라미터도 애노테이션으로 처리 
 */
@WebServlet(
  urlPatterns={"/member/update"},
  initParams={
	  @WebInitParam(name="driver",value="com.mysql.jdbc.Driver"),
	  @WebInitParam(name="url",value="jdbc:mysql://localhost/studydb"),
	  @WebInitParam(name="username",value="study"),
	  @WebInitParam(name="password",value="wer053mysql")
  }
)
public class MemberUpdateServlet extends HttpServlet {
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

			Member member = memberDao.selectOne(Integer.parseInt(request.getParameter("no")));

			request.setAttribute("member", member);

			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberUpdateForm.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			Class.forName(this.getInitParameter("driver"));
//			conn = DriverManager.getConnection(
//						this.getInitParameter("url"),
//						this.getInitParameter("username"),
//						this.getInitParameter("password")); 
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(
//				"SELECT MNO,EMAIL,MNAME,CRE_DATE FROM MEMBERS" + 
//				" WHERE MNO=" + request.getParameter("no"));	
//			if(rs.next()){
//				request.setAttribute("member",
//						new Member()
//							.setNo(rs.getInt("MNO"))
//							.setEmail(rs.getString("EMAIL"))
//							.setName(rs.getString("MNAME"))
//							.setCreatedDate(rs.getDate("CRE_DATE")));
//			} else {
//				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
//			}
//			
//			RequestDispatcher rd = request.getRequestDispatcher(
//					"/member/MemberUpdateForm.jsp");
//			rd.forward(request, response);
//			/*
//			PrintWriter out = response.getWriter();
//			out.println("<html><head><title>회원정보</title></head>");
//			out.println("<body><h1>회원정보</h1>");
//			out.println("<form action='update' method='post'>");
//			out.println("번호: <input type='text' name='no' value='" +
//				request.getParameter("no") + "' readonly><br>");
//			out.println("이름: <input type='text' name='name'" +
//				" value='" + rs.getString("MNAME")  + "'><br>");
//			out.println("이메일: <input type='text' name='email'" +
//				" value='" + rs.getString("EMAIL")  + "'><br>");
//			out.println("가입일: " + rs.getDate("CRE_DATE") + "<br>");
//			out.println("<input type='submit' value='저장'>");
//			out.println("<input type='button' value='취소'" + 
//				" onclick='location.href=\"list\"'>");
//			out.println("</form>");
//			out.println("</body></html>");
//			*/
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("error", e);
//			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
//			rd.forward(request, response);
//		} finally {
//			try {if (rs != null) rs.close();} catch(Exception e) {}
//			try {if (stmt != null) stmt.close();} catch(Exception e) {}
//			try {if (conn != null) conn.close();} catch(Exception e) {}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			
//			Connection conn = (Connection) sc.getAttribute("conn");
//			MemberDao memberDao = new MemberDao();
//			memberDao.setConnection(conn);

			memberDao.update(new Member()
					.setNo(Integer.parseInt(request.getParameter("no")))
					.setName(request.getParameter("name"))
					.setEmail(request.getParameter("email")));

			response.sendRedirect("list");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}

//		request.setCharacterEncoding("UTF-8");
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		try {
//			Class.forName(this.getInitParameter("driver"));
//			conn = DriverManager.getConnection(
//						this.getInitParameter("url"),
//						this.getInitParameter("username"),
//						this.getInitParameter("password")); 
//			stmt = conn.prepareStatement(
//					"UPDATE MEMBERS SET EMAIL=?,MNAME=?,MOD_DATE=now()"
//					+ " WHERE MNO=?");
//			stmt.setString(1, request.getParameter("email"));
//			stmt.setString(2, request.getParameter("name"));
//			stmt.setInt(3, Integer.parseInt(request.getParameter("no")));
//			stmt.executeUpdate();
//			
//			response.sendRedirect("list");
//			
//		} catch (Exception e) {
//			throw new ServletException(e);
//			
//		} finally {
//			try {if (stmt != null) stmt.close();} catch(Exception e) {}
//			try {if (conn != null) conn.close();} catch(Exception e) {}
//		}
	}
}
