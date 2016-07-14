package AddressBook.model;

/**
*
* @author Peter Wong
*/


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addressbook")
public class Person{
	private long personId;
	private String name;
	private String email;
	private String phone;
		private String address;


	
	public Person(){}
	public Person(String name, String email, String phone, String address){

		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
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

	public void setName(String name){
		this.name = name;
	}
	@Column(name="name", unique=true, nullable = false, length = 256)
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

	public void setAddress(String address){
		this.address = address;
	}
	@Column(name="address", nullable = false, length = 256)
	public String getAddress() {
		return address;
	}
			
	
}
