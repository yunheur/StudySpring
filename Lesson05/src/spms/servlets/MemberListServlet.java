package spms.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
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
			
//			Connection conn = (Connection) sc.getAttribute("conn");
//			MemberDao memberDao = new MemberDao();
//			memberDao.setConnection(conn);
			
			request.setAttribute("members", memberDao.selectList());
			
			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberList.jsp");
			rd.include(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
//		//[DAO 쓰지 않을 경우]
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			ServletContext sc = this.getServletContext();
//			/*Class.forName(sc.getInitParameter("driver"));
//			conn = DriverManager.getConnection(
//						sc.getInitParameter("url"),
//						sc.getInitParameter("username"),
//						sc.getInitParameter("password")); */
//			conn = (Connection)sc.getAttribute("conn");
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(
//					"SELECT MNO,MNAME,EMAIL,CRE_DATE" + 
//					" FROM MEMBERS" +
//					" ORDER BY MNO ASC");
//			
//			response.setContentType("text/html; charset=UTF-8");
//			ArrayList<Member> members = new ArrayList<Member>();
//			
//			// 데이터베이스에서 회원 정보를 가져와 Member에 담는다.
//			// 그리고 Member객체를 ArrayList에 추가한다.
//			while(rs.next()) {
//				members.add(new Member()
//							.setNo(rs.getInt("MNO"))
//							.setName(rs.getString("MNAME"))
//							.setEmail(rs.getString("EMAIL"))
//							.setCreatedDate(rs.getDate("CRE_DATE"))	);
//			}
//			
//			// request에 회원 목록 데이터 보관한다.
//			request.setAttribute("members", members);
//			
//			// JSP로 출력을 위임한다.
//			RequestDispatcher rd = request.getRequestDispatcher(
//					"/member/MemberList.jsp");
//			// RequestDispatcher를 얻었다면 포워드하거나 인클루드 해야한다. 
//			// 포워드로 위임하면 해당 서블릿으로 제어권이 넘어간 후 다시 돌아오지 않는다. 
//			// 인클루드로 위임하면 해당 서블릿으로 제어권을 넘긴 후 그 서블릿이 작업을 끝내면 다시 제어권이 넘어온다. 
//			// 	inculde함수 다음에 추가 작업을 할 경우를 고려한다. 
//			rd.include(request, response);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("error", e);
//			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
//			rd.forward(request, response);
//		} finally {
//			try {if (rs != null) rs.close();} catch(Exception e) {}
//			try {if (stmt != null) stmt.close();} catch(Exception e) {}
//			//try {if (conn != null) conn.close();} catch(Exception e) {}
//		}
	}

}
