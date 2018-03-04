package spms.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import spms.context.ApplicationContext;

/**
 * Application Lifecycle Listener implementation class ContextLoaderListener
 *
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
	//Connection conn;
	//BasicDataSource ds;
	static ApplicationContext applicationContext;
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		try {
			ServletContext sc = event.getServletContext();
			
			String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			applicationContext = new ApplicationContext(propertiesPath);
			
			// 톰캣서버에서 서버자원 찾아 사용하기  
//			InitialContext initialContext = new InitialContext();
//			DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/studydb");
//			
//			MySqlMemberDao memberDao = new MySqlMemberDao();
//			memberDao.setDataSource(ds);
//
//			sc.setAttribute("/auth/login.do", new LogInController().setMemberDao(memberDao));
//			sc.setAttribute("/auth/logout.do", new LogOutController());
//			sc.setAttribute("/member/list.do", new MemberListController().setMemberDao(memberDao));
//			sc.setAttribute("/member/add.do", new MemberAddController().setMemberDao(memberDao));
//			sc.setAttribute("/member/update.do", new MemberUpdateController().setMemberDao(memberDao));
//			sc.setAttribute("/member/delete.do", new MemberDeleteController().setMemberDao(memberDao));
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
