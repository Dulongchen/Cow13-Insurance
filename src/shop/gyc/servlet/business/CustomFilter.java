package shop.gyc.servlet.business;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.gyc.service.Business;
import shop.gyc.service.Custom;

/**
 * Servlet Filter implementation class BusinessFilter
 */
@WebFilter(filterName = "CustomFilter", urlPatterns = { "/custom/*" })
public class CustomFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CustomFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	//核心的方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		Custom custom = (Custom) session.getAttribute("custom");
		if (custom == null) {
			request.setAttribute("info", "请先登录再经行操作");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			//res.sendRedirect("../Login");
		} else {
			chain.doFilter(request, response);
		}
		
		
		
		// pass the request along the filter chain
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
