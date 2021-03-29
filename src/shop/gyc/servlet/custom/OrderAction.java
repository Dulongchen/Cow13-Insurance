package shop.gyc.servlet.custom;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
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
@WebServlet("/custom/OrderAction")
public class OrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("temp_order");

		request.setCharacterEncoding("utf-8");
		String address = request.getParameter("address");
		String contacts = request.getParameter("contacts");
		String phone = request.getParameter("phone");
		Custom custom = (Custom) session.getAttribute("custom");

		order.setAddress(address);
		order.setContacts(contacts);
		order.setPhone(phone);
		order.setCustomId(custom.getId());
		order.setOrderTime(new Date());
		order.setSum(order.calcTotal());

		try {
			MyService.saveOrder(order);

			session.removeAttribute("temp_order");
			for (OrderItem item : order.getOrderItems()) {
				System.out.println(item.getCartid());
			}
			request.setAttribute("order", order);
			request.getRequestDispatcher("/jsp/order-pay.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
