package spms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */

@WebFilter(
		urlPatterns="/*",
		initParams={
				@WebInitParam(name="encoding", value="UTF-8")
		})

public class CharacterEncodingFilter implements Filter {

	FilterConfig config;

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 서블릿이 실행되기 전에 해야할 작업"
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		//response.setCharacterEncoding(config.getInitParameter("encoding"));
		
		// 다음 필터를 호출. 더이상 필터가 없다면 서블릿의 service()가 호출
		nextFilter.doFilter(request, response);
		
		// 서블릿을 실행한 후, 클라이언트에게 응답하기 전에 해야할 작
		
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
