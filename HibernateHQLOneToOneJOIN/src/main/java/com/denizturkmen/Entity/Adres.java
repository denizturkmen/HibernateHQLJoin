package com.denizturkmen.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Adress_table")
public class Adres {

	@Id
	@Column(name="adress_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adresId;
	
	@Column(name = "street_name",length=50)
    private String street;
    
	@Column(name = "city_name",length=50)
    private String city;
   
	@Column(name = "state_name")
    private String state;
    
	@Column(name = "pin_code")
    private Long pincode;
	
	@OneToOne(mappedBy = "adres")
	private Employee employee;

	public Integer getAdresId() {
		return adresId;
	}

	public void setAdresId(Integer adresId) {
		this.adresId = adresId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Adres [street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
