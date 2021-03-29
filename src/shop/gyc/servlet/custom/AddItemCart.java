package shop.gyc.servlet.custom;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.gyc.service.Custom;
import shop.gyc.service.MyService;

/**
 * Servlet implementation class AddItemCart
 */
@WebServlet("/custom/AddItemCart")
public class AddItemCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String goodsId = request.getParameter("goodsId");
		String num = request.getParameter("num");
		HttpSession session = request.getSession();
		Custom custom = (Custom) session.getAttribute("custom");
		
		try {
			MyService.addCartItem(custom.getId(), Integer.parseInt(goodsId), Integer.parseInt(num));
		
			request.getRequestDispatcher("/custom/MyCart").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
