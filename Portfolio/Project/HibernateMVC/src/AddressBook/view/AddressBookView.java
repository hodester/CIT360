package AddressBook.view;
/**
*
* @author Peter Wong
*/


import AddressBook.model.Person;

public class AddressBookView {
	public void printinfo(String line){
		System.out.println(line);
	}
	public void printError(String line){
		System.err.println(line);
	}
	public void printPrompt(String line){
		System.out.print(line);
	}
	public void printperson(Person person){
		System.out.println("Person ID: " + person.getPersonId()); 
		System.out.println("Name: " + person.getName());
		System.out.println("Email: " + person.getEmail());
		System.out.println("Phone: " + person.getPhone());
		System.out.println("Address: "  + person.getAddress() + "\n");
	}

}
