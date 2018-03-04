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
import spms.vo.Member;

/**
 * Servlet implementation class MemberAddServlet
 */
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		RequestDispatcher rd = request.getRequestDispatcher("/member/MemberForm.jsp");
		rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		/*
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>회원 등록</title></head>");
		out.println("<body><h1>회원 등록</h1>");
		out.println("<form action='add' method='post'>");
		out.println("이름: <input type='text' name='name'><br>");
		out.println("이메일: <input type='text' name='email'><br>");
		out.println("암호: <input type='password' name='password'><br>");
		out.println("<input type='submit' value='추가'>");
		out.println("<input type='reset' value='취소'>");
		out.println("</form>");
		out.println("</body></html>");
		*/
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			
//			Connection conn = (Connection) sc.getAttribute("conn");
//			MemberDao memberDao = new MemberDao();
//			memberDao.setConnection(conn);
			
			memberDao.insert(new Member()
					.setEmail(request.getParameter("email"))
					.setPassword(request.getParameter("password"))
			        .setName(request.getParameter("name")));
			
			response.sendRedirect("list");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		
//		// CharacterEncodingFilter에서 처리 
//		// (테스트 해본 결과 CharacterEncodingFilter나 request.setCharacterEncoding("UTF-8")을 하지 않는 경우 한글 저장이 재대로 이루어지지 않는다.
//		//request.setCharacterEncoding("UTF-8");
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		try {
//			System.out.println(request.getParameter("name"));
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//			conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost/studydb", 
//					"study", 
//					"wer053mysql");
//			stmt = conn.prepareStatement("INSERT INTO MEMBERS(EMAIL,PWD,MNAME,CRE_DATE,MOD_DATE)"
//					+ " VALUES (?,?,?,NOW(),NOW())");
//			stmt.setString(1, request.getParameter("email"));
//			stmt.setString(2, request.getParameter("password"));
//			stmt.setString(3, request.getParameter("name"));
//			stmt.executeUpdate();
//			
//			// 리다이랙트를 이용한 리프래시
//			response.sendRedirect("list");
//			
//			response.setContentType("text/html; charset=UTF8");
//			PrintWriter out = response.getWriter();
//			out.println("<html><head><title>회원등록결과</title></head>");
//			out.println("<meta http-equiv='Refresh' content='1;url=list'>");
//			out.println("<body>");
//			out.println("<p>등록 성공입니다!</p>");	
//			out.println("<p><a href='list'>회원목록</a></p>");
//			out.println("</body></html>");
//			
//			// 리프래시 정보를 응답 헤더에 추가
//			//response.addHeader("Refresh", "1;url=list");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("error", e);
//			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
//			rd.forward(request, response);
//		} finally {
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (Exception e) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//			}
//		}
	}

}
