package shop.gyc.servlet.business;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.gyc.service.Goods;
import shop.gyc.service.MyService;

/**
 * Servlet implementation class GoodsUpdate
 */
@WebServlet("/business/GoodsUpdate")
public class GoodsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("goodsId");
		try {
			Goods goods = MyService.findGoodsById(Integer.parseInt(id));
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("/jsp/goodsUpdate-business.jsp").forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
