/**
*
* @author Peter Wong
* @description This is a test for Calendar Database module
* @notes This will test the 5 functions which are addPerson, getPerson, updatePerson, removePerson, and DBConnect
*/

public class ModTest {

	public static void main(String[] args) {
		System.err.println("Starting Application\nConnecting to Database using Hibernate\n");
				
		AddressBookDB.connectDB();
		
		System.err.println("\n\n\n\n");

		AddressBookDB CD = new AddressBookDB();
		
		String sampledate = getRandomDate();
		
		Long personID1 = CD.addPerson("Peter", getRandomDate(), "Peter@domain.com", "(858) 123-4567", new Address("123 Fake Street", "San Dieg", "CA", "91219"));
		System.err.println("Added entry new ID is " + personID1 +"\n");

		Long personID2 = CD.addPerson("Jennifer", sampledate, "Jennifer@domain.com", "(858) 123-4568", new Address("123 Fake Street", "San Dieg", "CA", "91219"));
		System.err.println("Added entry new ID is " + personID2 +"\n");
		
		Long personID3 = CD.addPerson("Simon", getRandomDate(), "Simon@domain.com", "(858) 123-4569", new Address("125 Fake Street", "San Dieg", "CA", "91219"));
		System.err.println("Added entry new ID is " + personID3 +"\n");
		
		Long personID4 = CD.addPerson("Theodore", getRandomDate(), "Theodore@domain.com", "(858) 123-4569", new Address("125 Fake Street", "San Dieg", "CA", "91219"));
		System.err.println("Added entry new ID is " + personID4 +"\n");
		
		Long personID5 = CD.addPerson("Brittany", getRandomDate(), "Brittany@domain.com", "(858) 123-4569", new Address("125 Fake Street", "San Dieg", "CA", "91219"));
		System.err.println("Added entry new ID is " + personID5 +"\n");
		
		Long personID6 = CD.addPerson("Jeanette", getRandomDate(), "Jeanette@domain.com", "(858) 123-4569", new Address("125 Fake Street", "San Dieg", "CA", "91219"));
		System.err.println("Added entry new ID is " + personID6 +"\n");

		
		
		Person results = (Person) CD.getPersonByName("Peter");
		System.err.println("Results\nID:" + results.getPersonId() + "\nDate of Birth: " + results.getDob() + "\nName: "  + results.getName() + "\nEmail: "  + results.getEmail() + "\nPhone: "  + results.getPhone() + "\nAddress: "  + results.getAddress().toString() +"\n");
	
	
		results = (Person) CD.getPersonByID(personID1);
		System.err.println("Results\nID:" + results.getPersonId() + "\nDate of Birth: " + results.getDob() + "\nName: "  + results.getName() + "\nEmail: "  + results.getEmail() + "\nPhone: "  + results.getPhone() + "\nAddress: "  + results.getAddress().toString() +"\n");
	
		System.err.println("Deleting record " + personID4 + "\n");
		CD.deletePersonByID(personID4);
		
		Long personIDupdate = CD.updatePersonByID(personID1,"Peter Wong", getRandomDate(), "Peter@domain.com", "(858) 123-4567", new Address("123 Fake Street", "San Dieg", "CA", "91219"));
		System.err.println("Updated entry ID: " + personIDupdate +"\n");
		
		results = (Person) CD.getPersonByID(personIDupdate);
		System.err.println("Results\nID:" + results.getPersonId() + "\nDate of Birth: " + results.getDob() + "\nName: "  + results.getName() + "\nEmail: "  + results.getEmail() + "\nPhone: "  + results.getPhone() + "\nAddress: "  + results.getAddress().toString() + "\n");


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
