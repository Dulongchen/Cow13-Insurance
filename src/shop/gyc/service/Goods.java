package shop.gyc.service;

import java.math.BigDecimal;
import java.sql.Date;

public class Goods {

	private long id;
	private String itemname;
	private long businessid;
	private BigDecimal price;
	private String details;
	private String itemimg;
	private boolean states;
	private String shopname;
	
	public String getStatesCn(){
		if(this.states) {
			return"住校中";
		}
		else {
			return"离校";
		}
		
	}
	
	
	
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public long getBusinessid() {
		return businessid;
	}
	public void setBusinessid(long businessid) {
		this.businessid = businessid;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getItemimg() {
		return itemimg;
	}
	public void setItemimg(String itemimg) {
		this.itemimg = itemimg;
	}
	public boolean isStates() {
		return states;
	}
	public void setStates(boolean states) {
		this.states = states;
	}
	


}
