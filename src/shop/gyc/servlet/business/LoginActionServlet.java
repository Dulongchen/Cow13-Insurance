package shop.gyc.servlet.business;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.gyc.service.Business;
import shop.gyc.service.Custom;
import shop.gyc.service.MyService;

/**
 * Servlet implementation class LoginActionServlet
 */
@WebServlet("/LoginAction")
public class LoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String role = request.getParameter("role");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if ("business".equals(role)) {
			try {
				Business business = MyService.findBusiness(username, password);
				if (business != null) {
					HttpSession session = request.getSession();
					session.setAttribute("business", business);
					
					
					
					
					response.sendRedirect("business/GoodsManager");
					
				}
				else {
					request.setAttribute("info", "用户名或密码错误，请重新登录!");
					request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				Custom custom = MyService.findCustom(username, password);
				if (custom!= null) {
					HttpSession session = request.getSession();
					session.setAttribute("custom", custom);
					
					
					
					
					response.sendRedirect("./Default");
					
				}
				else {
					request.setAttribute("info", "用户名或密码错误，请重新登录!");
					request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
