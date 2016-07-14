package AddressBook.model;
/**
*
* @author Peter Wong
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddressBookModel {
	
		private String date;
		private String name;
		private String email;
		private String phone;
		private String address;
		private String notes;	
		
	public AddressBookModel(){
		
		
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getNnotes() {
		return notes;
	}
	
	public String[] NewEvent(){
	
		
		name = AskName();
		date = AskDate();
		email = AskEmail();
		phone = AskPhone();
		address = AskAddress();
		notes = AskNotes();
		String[] array = {name, date, email, phone, address, notes};
		return array;
	}

	public String[] UpdateEvent( String eventID){
	
		
		name = AskName();
		date = AskDate();
		email = AskEmail();
		phone = AskPhone();
		address = AskAddress();
		notes = AskNotes();
		String[] array = {eventID, name, date, email, phone, address, notes};
		return array;
	}	
	
	private String AskName(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Please enter your name: ");
	    String input = null;
	    try {
	    	input = reader.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("You entered : " + input);
		return input;
	}	
	private String AskDate(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Please enter your selected appointment date (Format 06/27/2016): ");
	    String input = null;
	    try {
	    	input = reader.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("You entered : " + input);
		return input;
	}

	private String AskEmail(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Please enter your email address: ");
	    String input = null;
	    try {
	    	input = reader.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("You entered : " + input);
		return input;
	}
	
	private String AskPhone(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Please enter your phone number: ");
	    String input = null;
	    try {
	    	input = reader.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("You entered : " + input);
		return input;
	}

	private String AskAddress(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Please enter your full address: ");
	    String input = null;
	    try {
	    	input = reader.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("You entered : " + input);
		return input;
	}

	private String AskNotes(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Please enter note for this appointment if any: ");
	    String input = null;
	    try {
	    	input = reader.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("You entered : " + input);
		return input;
	}
	
	
}
