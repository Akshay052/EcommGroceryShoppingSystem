package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

	private Integer paymentId;
	private double totalAmount;
	private String date;

	public Payment() {
		System.out.println("Payment constr");
	}
	public Payment(double totalAmount, String date) {
		super();
		this.totalAmount = totalAmount;
		this.date = date;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", totalAmount=" + totalAmount + ", date=" + date + "]";
	}
	
	

}
