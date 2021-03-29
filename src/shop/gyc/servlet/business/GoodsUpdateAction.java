package shop.gyc.servlet.business;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import shop.gyc.service.Business;
import shop.gyc.service.MyService;

/**
 * Servlet implementation class GoodsAddAction
 */

@WebServlet("/business/GoodsUpdateAction")
public class GoodsUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String goodsname = request.getParameter("goodsname");
		String sPrice = request.getParameter("price");
		String details = request.getParameter("details");

		BigDecimal price = new BigDecimal(sPrice);
		
		try {
			MyService.updateGoods(Integer.parseInt(id), goodsname, price, details);
			request.setAttribute("info", "更新成功");
			request.getRequestDispatcher("GoodsManager").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
