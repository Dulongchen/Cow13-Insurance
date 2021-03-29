package shop.gyc.service;

import java.math.BigDecimal;

public class OrderItem {

	private int id;
	private int goodsid;
	private String itemname;
	private String itemimg;
	private BigDecimal price; 
	private int num;
	
	
	private int cartid;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getGoodsid() {
		return goodsid;
	}


	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public String getItemimg() {
		return itemimg;
	}


	public void setItemimg(String itemimg) {
		this.itemimg = itemimg;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public int getCartid() {
		return cartid;
	}


	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	
	
	
	
	
	
	
	
	
	
	
}
