package shop.gyc.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

public class MyService {

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/db610";
		String username = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, username, password);

		return conn;
	}

	public static Custom findCustom(String username, String password) throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * from t_custom WHERE username=? and password=?";

		Custom custom = qr.query(conn, sql, new BeanHandler<Custom>(Custom.class), username, password);
		DbUtils.close(conn);
		return custom;
	}

	public static Business findBusiness(String username, String password) throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * from t_business WHERE loginname=? and password=?";

		Business business = qr.query(conn, sql, new BeanHandler<Business>(Business.class), username, password);
		DbUtils.close(conn);
		return business;
	}

	public static void updatGoodsStates(int goodsId, int states) throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "update t_goods set states=? where id=?";
		qr.update(conn, sql, states, goodsId);
		DbUtils.close(conn);
	}

	public static void addGoods(String itemname, long businessid, BigDecimal price, String details, String imgname)
			throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "insert into t_goods(itemname,businessid,price,details,itemimg)VALUES(?,?,?,?,?)";
		qr.update(conn, sql, itemname, businessid, price, details, imgname);
		DbUtils.close(conn);
	}

	public static List<Goods> findGoodsByBusiness(int businessId) throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from t_goods where businessid=?";

		List<Goods> goodsList = qr.query(conn, sql, new BeanListHandler<Goods>(Goods.class), businessId);
		DbUtils.close(conn);

		return goodsList;

	}

	public static List<Goods> findAllGoods() throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT t_goods.id,t_goods.itemname,t_goods.businessid,t_goods.price,t_goods.details,t_goods.itemimg,t_goods.states,t_business.shopname from t_goods,t_business where t_goods.businessid = t_business.id and states=1";

		List<Goods> goodsList = qr.query(conn, sql, new BeanListHandler<Goods>(Goods.class));
		DbUtils.close(conn);

		return goodsList;
	}

	public static Goods findGoodsById(int id) throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();

		String sql = "SELECT t_goods.id,t_goods.itemname,t_goods.businessid,t_goods.price,t_goods.details,t_goods.itemimg,t_goods.states,t_business.shopname from t_goods,t_business where t_goods.businessid = t_business.id and states=1 and t_goods.id=?";

		Goods goods = qr.query(conn, sql, new BeanHandler<Goods>(Goods.class), id);
		DbUtils.close(conn);

		return goods;
	}

	public static void updateGoods(int id, String itemname, BigDecimal price, String details) throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "update t_goods set itemname=?,price=?,details=? where id=?;";
		qr.update(conn, sql, itemname, price, details, id);
		DbUtils.close(conn);
	}

	public static void addCartItem(int customId, int goodsId, int num) throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "insert into t_cart(customid,goodsid,num) values(?,?,?) on DUPLICATE key update num=num+?";
		// String sql = "insert into t_cart(customid,goodsid,num)VALUES(?,?,?)";
		qr.update(conn, sql, customId, goodsId, num, num);
		DbUtils.close(conn);
	}

	public static List<CartItem> getCartItems(int customid) throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();

		String sql = "select t_cart.id,t_cart.num,t_goods.itemname,t_goods.itemimg,t_goods.price from t_cart,t_goods where t_cart.goodsid = t_goods.id and customid = ?";

		List<CartItem> items = qr.query(conn, sql, new BeanListHandler<CartItem>(CartItem.class), customid);
		DbUtils.close(conn);

		return items;
	}

	public static List<OrderItem> createOrderItemsByIds(String[] ids) throws SQLException {
		List<OrderItem> items = new ArrayList<>();
		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();
		for (int i = 0; i < ids.length; i++) {
			int cartid = Integer.parseInt(ids[i]);
			String sql = "select t_cart.id as cartid,t_cart.num,t_cart.goodsid,t_goods.itemname,t_goods.itemimg,t_goods.price from t_cart,t_goods where t_cart.goodsid = t_goods.id and t_cart.id=?";

			OrderItem orderItem = qr.query(conn, sql, new BeanHandler<>(OrderItem.class), ids[i]);

			items.add(orderItem);

		}
		DbUtils.close(conn);
		return items;
	}

	public static void saveOrder(Order order) throws SQLException {

		Connection conn = MyService.getConnection();
		QueryRunner qr = new QueryRunner();

		String sql = "insert into t_order(id,customId,sum,phone,address,contacts,orderTime) values(?,?,?,?,?,?,?)";

		qr.update(conn, sql, order.getId(), order.getCustomId(), order.getSum(), order.getPhone(), order.getAddress(),
				order.getContacts(), order.getOrderTime());

		sql = "insert into t_orderitem(orderId,goodsId,num) values(?,?,?)";

		for (OrderItem item : order.getOrderItems()) {

			qr.update(conn, sql, order.getId(), item.getGoodsid(), item.getNum());
		}

		DbUtils.close(conn);

	}


}