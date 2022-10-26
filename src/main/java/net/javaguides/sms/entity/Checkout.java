package net.javaguides.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity

@Table(name = "checkout")

public class Checkout {

	

	@Id

	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "orderIdSequence")
	@SequenceGenerator(name = "orderIdSequence",initialValue = 1000, allocationSize = 1, sequenceName = "orderId")
	private Long id;

	@Column(name = "firstName", nullable = false)

	private String firstName;

	@Column(name = "lastName", nullable = false)

	private String lastName;
	
	@Column(name = "phone", nullable = false)

	private String phone;
	
	@Column(name = "email", nullable = false)

	private String email;
	
	@Column(name = "cardNumber", nullable = false)

	private String cardNumber;

 public Checkout() {

		

	}

	
	public Checkout(Long id, String firstName, String lastName, String phone, String email, String cardNumber,
			String expiryDate, String cvv) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	@Column(name = "expiryDate", nullable = false)

	private String expiryDate;
	

	@Column(name = "cvv", nullable = false)

	private String cvv;
	

	
}
	