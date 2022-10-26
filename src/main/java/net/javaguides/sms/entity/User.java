package net.javaguides.sms.entity;



import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "category", nullable = false)
private String category;

@Column(name = "skuid")
private String skuid;

@Column(name = "quantity")
private Integer quantity;

@Column(name = "title")
private String title;

@Column(name = "orderId")
private Long orderId;



public Long getOrderId() {
	return orderId;
}



public void setOrderId(Long orderId) {
	this.orderId = orderId;
}



public Integer getQuantity() {
	return quantity;
}



public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}



@Column(name = "discription")
private String discription;

@Column(name = "price")
private String price;







public User() {
super();
// TODO Auto-generated constructor stub
}



public User( String category, String skuid, String title, String discription, String price,
Integer quantity) {
super();

this.category = category;
this.skuid = skuid;
this.title = title;
this.discription = discription;
this.price = price;

this.quantity=quantity;

}



public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}

public String getCategory() {
return category;
}

public void setCategory(String category) {
this.category = category;
}





public String getSkuid() {
return skuid;
}



public void setSkuid(String skuid) {
this.skuid = skuid;
}



public String getTitle() {
return title;
}



public void setTitle(String title) {
this.title = title;
}



public String getDiscription() {
return discription;
}



public void setDiscription(String discription) {
this.discription = discription;
}



public String getPrice() {
return price;
}



public void setPrice(String price) {
this.price = price;
}








}