package MissionaryCal;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "address")
public class Address implements java.io.Serializable{
	private long addressId;
	private String address;
	private Set<Event> eventIds;
	
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
	@Column(name = "addressId")
	 
	public long getAddressId(){
		return this.addressId;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	@Column(name="address", nullable = false, length = 512)
	public String getAddress() {
		return this.address;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="eventId",  targetEntity=Event.class, fetch=FetchType.EAGER)
    public Set<Event> getEventIds()  
    {  
        return eventIds;  
    }  
    public void setEventIds(Set<Event> eventIds)  
    {  
        this.eventIds = eventIds;  
    } 
}
