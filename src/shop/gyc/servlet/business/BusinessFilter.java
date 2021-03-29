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

/**
 * Servlet Filter implementation class BusinessFilter
 */
@WebFilter(filterName = "Business", urlPatterns = { "/business/*" })
public class BusinessFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BusinessFilter() {
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
		Business business = (Business) session.getAttribute("business");
		if (business == null) {
			request.setAttribute("info", "商家请先登录再经行操作");
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
