package spms.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class ContextLoaderListener
 *
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
	static ClassPathXmlApplicationContext applicationContext;
	
	public static ClassPathXmlApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		try {			
			applicationContext = new ClassPathXmlApplicationContext("beans.xml");
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
