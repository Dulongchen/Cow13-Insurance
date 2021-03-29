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

import shop.gyc.service.CartItem;
import shop.gyc.service.Custom;
import shop.gyc.service.MyService;

/**
 * Servlet implementation class AddItemCart
 */
@WebServlet("/custom/MyCart")
public class MyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Custom custom = (Custom) session.getAttribute("custom");
		try {
			List<CartItem> items = MyService.getCartItems(custom.getId());
			
			request.setAttribute("items", items);
			
			request.getRequestDispatcher("/jsp/cart.jsp").forward(request, response);
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
