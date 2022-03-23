package com.shoppingcart.org.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "code")
	private String code;
	@Column(name = "discount")
	private BigDecimal discount;
	@Column(name = "exp_date")
	private String expDate;
	
	public Coupon() {
		
	}
	
	public Coupon(String code, BigDecimal discount, String expDate) {
		super();
		this.code = code;
		this.discount = discount;
		this.expDate = expDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public String getexpDate() {
		return expDate;
	}
	public void setexpDate(String expDate) {
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", code=" + code + ", discount=" + discount + ", expDate=" + expDate + "]";
	}
	
}
