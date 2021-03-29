package shop.gyc.servlet.business;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.gyc.service.MyService;

/**
 * Servlet implementation class GoodsAdd
 */
@WebServlet("/business/GoodsPutOn")
public class GoodsPutOn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("goodsId");
		System.out.print(id);
		try {
			MyService.updatGoodsStates(Integer.parseInt(id), 1);
			request.getRequestDispatcher("GoodsManager").forward(request, response);
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
