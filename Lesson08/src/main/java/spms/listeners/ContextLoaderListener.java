package spms.listeners;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spms.context.ApplicationContext;

/**
 * Application Lifecycle Listener implementation class ContextLoaderListener
 *
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
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
			applicationContext = new ApplicationContext();
			
			String resource = "spms/dao/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			applicationContext.addBean("sqlSessionFactory", sqlSessionFactory);
			
			ServletContext sc = event.getServletContext();
			System.out.println("test : " + sc.getInitParameter("contextConfigLocation"));
			String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			System.out.println("test : " + propertiesPath);
			applicationContext.prepareObjectsByProperties(propertiesPath);
			
			applicationContext.prepareObjectsByAnnotation("");
			applicationContext.injectDependency();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent event) {
	// TODO Auto-generated method stub
	}
}
