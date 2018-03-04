package spms.servlets;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class AppInitServlet
 * ContextLoaderListener로 대체
 */
@SuppressWarnings("serial")
public class AppInitServlet extends HttpServlet {

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("AppInitServlet 준비...");
		super.init(config);
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(sc.getInitParameter("url"), sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			sc.setAttribute("conn", conn);
		} catch (Throwable e) {
			throw new ServletException();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("AppInitServlet 마무리...");
		super.destroy();
		Connection conn = (Connection) this.getServletContext().getAttribute("conn");
		try {
			if (conn != null && conn.isClosed() == false) {
				conn.close();
			}
		} catch (Exception e) {
		}
	}
}
