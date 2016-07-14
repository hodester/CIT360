package AddressBook.controller;
/**
*
* @author Peter Wong
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import AddressBook.model.*;
import AddressBook.view.*;


public class AddressBookController {
	   private Person model;
	   private static AddressBookView view;
	   private static HibernateDB CD;
	   boolean exit;

	   public AddressBookController(Person model, AddressBookView view){
	      this.model = model;
	      this.view = view;
	      view.printinfo("Starting Application\nConnecting to Database using Hibernate\n");
	      HibernateDB.connectDB();
	      CD = new HibernateDB();
	      
	   }
	public void seedData(){
		
		addPerson("Peter", "Peter@domain.com", "(858) 123-4567", "123 Fake Street, San Diego, CA 91219");
		addPerson("Jennifer", "Jennifer@domain.com", "(858) 123-4568", "123 Fake Street, San Diego, CA 91219");
		addPerson("Simon", "Simon@domain.com", "(858) 123-4569", "125 Fake Street, San Diego, CA 91219");
		addPerson("Theodore", "Theodore@domain.com", "(858) 123-4569", "125 Fake Street, San Diego, CA 91219");
		addPerson("Brittany", "Brittany@domain.com", "(858) 123-4569", "125 Fake Street, San Diego, CA 91219");
		addPerson( "Jeanette", "Jeanette@domain.com", "(858) 123-4569", "125 Fake Street, San Diego, CA 91219");
	}
	public void addPerson(String name, String email, String phone, String address){
		Long eventID1 = CD.addPerson(name, email, phone, address);
		view.printinfo("Added entry new ID is " + eventID1 +"\n");

	}
	public void addPersonPrompt(){
		view.printinfo("New Address Book Entry:");
		
		String name = getInput("Full Name:");
		String email = getInput("Email Address:");
		String phone = getInput("Phone Number:");
		String address = getInput("Address:");
		Long eventID1 = CD.addPerson(name, email, phone, address);
		view.printinfo("Added entry new ID is " + eventID1 +"\n");

	}
	public void updatePersonPrompt(){
		view.printinfo("Edit Address Book Entry:");
		
		long id = Long.parseLong(getInput("Enter in Entry ID to update"));
		String name = getInput("Full Name:");
		String email = getInput("Email Address:");
		String phone = getInput("Phone Number:");
		String address = getInput("Address:");
		Long eventID1 = CD.updatPersonByID(id, name, email, phone, address);
		view.printinfo("Updated entry ID is " + eventID1 +"\n");

	}
	public void deletePersonPrompt(){
		view.printinfo("Delete Address Book Entry by ID:");
		
		long id = Long.parseLong(getInput("Enter in Entry ID to delete"));
		Long eventID1 = CD.deletePersonByID(id);
		view.printinfo("Deleted entry ID is " + eventID1 +"\n");

	}
	public void displayPerson(String name){
		Person result = (Person) CD.getPersonByName(name);
		if(result != null){
			view.printperson(result);
		}else{
			view.printinfo("Entry for " +name+ " in the Address Book not found.");
		}
	}
	public void displayPerson(long id){
		Person result = (Person) CD.getPersonByID(id);
		if(result != null){
			view.printperson(result);
		}else{
			view.printinfo("Entry for ID " +id+ " in the Address Book not found.");
		}
	}
	public void listPeople(){
		view.printinfo("\nCurrent entries in the Address Book:");
		@SuppressWarnings("unchecked")
		List<Person> persons = (List<Person>) CD.getPersons();
		
		Iterator<Person> crunchifyIterator = persons.iterator();
		if (crunchifyIterator.hasNext()){
		while (crunchifyIterator.hasNext()) {
			view.printperson(crunchifyIterator.next());
		}
		}else{
			view.printinfo("No entries in the Address Book found.");
		}

	}
	private String getInput(String prompt){
		String input = null;
		while(true) {
		view.printPrompt(prompt);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	    try {
	    	input = reader.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		view.printinfo("You entered: " + input );
		
		if (input.isEmpty()) {
		    continue;
		}else{
			break;
		}
		}

		return input;

	}


	public void startMenu(){
		Scanner in = new Scanner(System.in);
		int option = 0;
		printWelcome();
		while(!exit){
			displayMenu();
			option = 0;

			String msg = in.nextLine();
			if (msg == "" || msg.isEmpty()){
				option = 0;
			}else{
				try{
				option = Integer.valueOf(msg);
				}
			catch(NumberFormatException e){
				view.printError("Invalid Option");
				continue;
				}
			}
			
			
            switch (option) {
            case 1:  
            	listPeople();
            	break;
            case 2:  
            	addPersonPrompt();
            	break;
            case 3:  
            	updatePersonPrompt();
            	break;
            case 4:  
            	deletePersonPrompt();
            	break;
            case 5:  
            	seedData();
            	break;
            case 9:  
            	exit = true;
            	break;
            default: 
            	view.printError("Invalid Option");
            	break;

        }

		}
		in.close();
		view.printinfo("Good Bye");
		System.exit(0);
	}
	public void printWelcome(){
	      view.printinfo("**** Address Book Application ****");
	}
	public void displayMenu(){
		view.printinfo("\nPlease make a selection: ");
		view.printinfo("1. List Address Book");
		view.printinfo("2. Add New Address Book Entry");
		view.printinfo("3. Update Address Book Entry");
		view.printinfo("4. Delete Address Book Entry");
		view.printinfo("5. Seed with Sample Data");
		view.printinfo("9. Exit");
	}
	public void executeTask(String option){
		
	}
	public static String getRandomDate()
    {
        String date="";
        int yearBegin=2016;
        int yearEnd=2017-yearBegin;

        date=""+(1 + (int)(Math.random() * 12)+"/"+(1 + (int)(Math.random() * 31)+"/"+(yearBegin + (int)(Math.random() * yearEnd))));
        return date;
    }
	
}
