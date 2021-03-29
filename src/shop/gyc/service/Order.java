package shop.gyc.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Order {

	private String id;
	private int customId;
	private String contacts;
	private String address;
	private String phone;
	private Date orderTime;
	private int state;
	private BigDecimal sum;
	
	public Order() {
		this.id = Order.createOrderId();
		this.orderItems = new ArrayList<>();
	}
	private List<OrderItem> orderItems;
	
	public List<OrderItem> getOrderItems(){
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems){
		this.orderItems = orderItems;
	}
	
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCustomId() {
		return customId;
	}
	public void setCustomId(int customId) {
		this.customId = customId;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public BigDecimal getSum() {
		return sum;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	
	
	public BigDecimal calcTotal() {
		BigDecimal sum = new BigDecimal(0);
		for(OrderItem item:this.orderItems) {
			sum = sum.add(item.getPrice().multiply(new BigDecimal(item.getNum())));
		}
		return sum;
	}
	
	
	
	public static String createOrderId() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
		int i = new Random().nextInt(899);
		String id = sdf.format(d)+String.valueOf(i+100);
		return id;
	}
	
	
}
