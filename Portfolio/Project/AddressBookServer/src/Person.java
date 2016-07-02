/**
*
* @author Peter Wong
* @description Calendar Database module for missionary calendar application
* @notes This contain 5 functions which are addEvent, getEvent, updateEvent, removeEvent, and DBConnect
*/

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "person", catalog = "addressbook", uniqueConstraints = {
		@UniqueConstraint(columnNames = "name")})
public class Person{
	private long personId;
	private String name;
	private Date dob;
	private String email;
	private String phone;
	
	private Set<Address> addresses = new HashSet<Address>(0);


	
	public Person(){}
	public Person(Date dob, String memberName, String memberEmail, String memberPhone){
		this.dob = dob;
		this.name = memberName;
		this.email = memberEmail;
		this.phone = memberPhone;

	}
	public Person(Date dob, String memberName, String memberEmail, String memberPhone, Set<Address> addresses){
		this.dob = dob;
		this.name = memberName;
		this.email = memberEmail;
		this.phone = memberPhone;
		this.addresses = addresses;

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

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "person_address", catalog = "mkyongdb", joinColumns = { 
	@JoinColumn(name = "personId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "addressId", nullable = false, updatable = false) })
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	
}
