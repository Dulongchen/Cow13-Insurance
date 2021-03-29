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
@MultipartConfig
@WebServlet("/business/GoodsAddAction")
public class GoodsAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String goodsname = request.getParameter("goodname");
		String sPrice = request.getParameter("price");
		String details = request.getParameter("details");

		BigDecimal price = new BigDecimal(sPrice);
		Part part = request.getPart("goodsimg");
		String appPath = this.getServletContext().getRealPath("/");
		String path = appPath + File.pathSeparator + "goodsimg" + File.pathSeparator;
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDDHHmmssS");
		String filename = sdf.format(d) + ".jpg";
		part.write(path + filename);
		HttpSession session = request.getSession();
		Business business = (Business) session.getAttribute("business");
		try {
			MyService.addGoods(goodsname, business.getId(), price, details, filename);
			request.setAttribute("info", "添加成功");
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
