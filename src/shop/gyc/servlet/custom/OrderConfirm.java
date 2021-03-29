package shop.gyc.servlet.custom;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.gyc.service.Custom;
import shop.gyc.service.MyService;
import shop.gyc.service.Order;
import shop.gyc.service.OrderItem;

/**
 * Servlet implementation class AddItemCart
 */
@WebServlet("/custom/OrderConfirm")
public class OrderConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] ids= request.getParameterValues("itemid");
		try {
			List<OrderItem> items =MyService.createOrderItemsByIds(ids);
			
			Order order = new Order();
			order.setOrderItems(items);
			
			HttpSession session = request.getSession();
			session.setAttribute("temp_order", order);
			
			request.getRequestDispatcher("/jsp/order-confirm.jsp").forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
