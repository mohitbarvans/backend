package com.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component		
@Entity
public class Cart {

	@Id
	@GeneratedValue
	private int cartId;
	
	private int cartproductId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userMailId")
	private User cartUserDetails;
	
	private double cartPrice;
	
	private int cartStock;
	
	private String cartImage;
	
	private String cartProductName;
	
	public Cart()
	{
		
	}
	
	public Cart(int cartId,int cartproductId,User cartUserDetails, double cartPrice,int cartStock,String cartImage,String cartProductName)
	{
		this.cartId=cartId;
		this.cartproductId=cartproductId;
		this.cartUserDetails=cartUserDetails;
		this.cartPrice=cartPrice;
		this.cartStock=cartStock;
		this.cartImage=cartImage;
		this.cartProductName=cartProductName;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartproductId() {
		return cartproductId;
	}

	public void setCartproductId(int cartproductId) {
		this.cartproductId = cartproductId;
	}

	public User getCartUserDetails() {
		return cartUserDetails;
	}

	public void setCartUserDetails(User cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}

	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCartStock() {
		return cartStock;
	}

	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}

	public String getCartImage() {
		return cartImage;
	}

	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}

	public String getCartProductName() {
		return cartProductName;
	}

	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	
}
