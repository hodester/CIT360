/**
*
* @author Peter Wong
* @description Calendar Database module for missionary calendar application
* @notes This contain 5 functions which are addEvent, getEvent, updateEvent, removeEvent, and DBConnect
*/

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person{
	private long personId;
	private String name;
	private Date dob;
	private String email;
	private String phone;
	
	private Address address;


	
	public Person(){}
	public Person(Date dob, String memberName, String memberEmail, String memberPhone, Address memberAddress){
		this.dob = dob;
		this.name = memberName;
		this.email = memberEmail;
		this.phone = memberPhone;
		this.address = memberAddress;

	}
	

	public void setPersonId(long id){
		this.personId = id;
		
	}
	@Id
	@GeneratedValue
	@Column(name = "personId", unique=true, nullable=false)
	public long getPersonId(){
		return this.personId;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Column(name="dob", nullable=false)
	public Date getDob() {
		return dob;
	}
	public void setName(String name){
		this.name = name;
	}
	@Column(name="name", nullable = false, length = 256)
	public String getName() {
		return this.name;
	}
	public void setEmail(String email){
		this.email = email;
	}
	@Column(name="email", nullable = false, length = 256)
	public String getEmail() {
		return email;
	}		

	public void setPhone(String phone){
		this.phone = phone;
	}
	@Column(name="phone", nullable = false, length = 256)
	public String getPhone() {
		return phone;
	}	
	public void setAddress(Address address){
		this.address = address;
	}
	
	@ManyToOne(cascade = {CascadeType.PERSIST}, targetEntity=Address.class, optional = true, fetch=FetchType.EAGER)
	@JoinColumn(name="addressId")
	public Address getAddress() {
		return address;
	}
	
	
	
}
