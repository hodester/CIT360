package MissionaryCal;

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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eventcalendar")
public class Event implements java.io.Serializable{
	private long eventId;
	private Date date;
	private String name;
	private String email;
	private String phone;
	
	private Address lkaddress;
	private String notes;

	
	public Event(){}
	public Event(Date eventDate, String memberName, String memberEmail, String memberPhone, Address memberAddress, String notes){
		this.date = eventDate;
		this.name = memberName;
		this.email = memberEmail;
		this.phone = memberPhone;
		this.lkaddress = memberAddress;
		this.notes = notes;
	}
	

	public void setEventId(long id){
		this.eventId = id;
		
	}
	@Id
	@GeneratedValue
	@Column(name = "eventId")
	public long getEventId(){
		return this.eventId;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="eventDate")
	public Date getDate() {
		return date;
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
		return this.email;
	}		

	public void setPhone(String phone){
		this.phone = phone;
	}
	@Column(name="phone", nullable = false, length = 256)
	public String getPhone() {
		return this.phone;
	}	
	public void setLkAddress(Address address){
		this.lkaddress = address;
	}
	
	@ManyToOne(cascade = {CascadeType.ALL},targetEntity=Address.class)
	@JoinColumn(name="addressId") 
	public Address getLkAddress() {
		return this.lkaddress;
	}
	
	public void setNotes(String notes){
		this.notes = notes;
	}
	@Column(name="notes", nullable = true, length = 512)
	public String getNotes() {
		return this.notes;
	}		
	
}
