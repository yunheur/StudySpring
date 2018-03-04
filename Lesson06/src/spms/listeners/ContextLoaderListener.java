package spms.listeners;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import spms.dao.MemberDao;

/**
 * Application Lifecycle Listener implementation class ContextLoaderListener
 *
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
	//Connection conn;
	//BasicDataSource ds;
	
	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		try {
			ServletContext sc = event.getServletContext();
			
			// 직접 데이터베이스 정보 입력 
//			Class.forName(sc.getInitParameter("driver"));
//			conn = DriverManager.getConnection(sc.getInitParameter("url"), sc.getInitParameter("username"),
//					sc.getInitParameter("password"));
			
			// DD파일에서 데이터베이스 정보 얻어오기 
//			ds = new BasicDataSource();
//			ds.setDriverClassName(sc.getInitParameter("driver"));
//			ds.setUrl(sc.getInitParameter("url"));
//			ds.setUsername(sc.getInitParameter("username"));
//			ds.setPassword(sc.getInitParameter("password"));
			
			// 톰캣서버에서 서버자원 찾아 사용하기  
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/studydb");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setDataSource(ds);

			sc.setAttribute("memberDao", memberDao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent event) {
	// TODO Auto-generated method stub
//			try {
//				if(ds != null) ds.close();
//			} catch (SQLException e) {
//			}
	}
}
