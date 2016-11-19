package MissionaryCal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "address")
public class Address{
	private long addressId;
	private String address;
	
	public Address(){
		
	}
	public Address(String address){
		this.address = address;
	}
	public void setAddressId(long id){
		this.addressId = id;
		
	}
	
	@Id
	@GeneratedValue
	@Column(name = "addressId", unique=true, nullable=false)
	 
	public long getAddressId(){
		return addressId;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	@Column(name="address", nullable = false, length = 512, unique=true)
	public String getAddress() {
		return address;
	}
	
}
