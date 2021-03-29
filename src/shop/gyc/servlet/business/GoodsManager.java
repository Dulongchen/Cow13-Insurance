package shop.gyc.servlet.business;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.gyc.service.Business;
import shop.gyc.service.Goods;
import shop.gyc.service.MyService;

/**
 * Servlet implementation class GoodsManager
 */
@WebServlet("/business/GoodsManager")
public class GoodsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Business business = (Business) session.getAttribute("business");
		try {
			List<Goods> goodsList = MyService.findGoodsByBusiness(business.getId());
			
			request.setAttribute("goodsList", goodsList);
			request.getRequestDispatcher("/jsp/goods-business.jsp").forward(request, response);
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher("/jsp/goods-business.jsp").forward(request, response);
		//HttpSession session = request.getSession();
		//Business business = (Business) session.getAttribute("business");
		//if (business == null) {
			//request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		//	response.sendRedirect("../Login");
		//} else {
		//	request.getRequestDispatcher("/jsp/goods-business.jsp").forward(request, response);
		//}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
