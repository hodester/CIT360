import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "address")
public class Address{
	private long addressId;
	private String street;
	private String city;
	private String state;
	private String zip;

	
	public Address(){
		
	}
	public Address(String street, String city, String state, String zip){
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
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
	
	public void setStreet(String street){
		this.street = street;
	}
	@Column(name="street", nullable = false, length = 512)
	public String getStreet() {
		return street;
	}

	public void setCity(String city){
		this.city = city;
	}
	@Column(name="city", nullable = false, length = 256)
	public String getCity() {
		return city;
	}
	
	public void setState(String state){
		this.state = state;
	}
	@Column(name="state", nullable = false, length = 128)
	public String getState() {
		return state;
	}
	
	public void setZip(String zip){
		this.zip = zip;
	}
	@Column(name="zip", nullable = false, length = 10)
	public String getZip() {
		return zip;
	}

	public String toString(){
		return street + ", " + city + ", " +  state + "" +  zip;
	}
	
}
