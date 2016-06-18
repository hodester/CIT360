package MissionaryCal;

/**
*
* @author Peter Wong
* @description This is a test for Calendar Database module
* @notes This will test the 5 functions which are addEvent, getEvent, updateEvent, removeEvent, and DBConnect
*/

public class ModTest {

	public static void main(String[] args) {

		CalDB.connectDB();
		CalDB CD = new CalDB();
		
		
		// Date eventDate, String memberName, String memberEmail, String memberPhone, String memberAddress, String notes


		Long eventID1 = CD.addEvent("6/20/2016", "Peter", "email@domain.com", "(858) 123-4567", "123 Fake Street, San Diego, CA 91219", "Test notes");
		System.err.println("Added entry new IS is " + eventID1);
		Long eventID2 = CD.addEvent("6/22/2016", "Jennifer", "email2@domain.com", "(858) 123-4568", "124 Fake Street, San Diego, CA 91219", "Test notes");
		System.err.println("Added entry new IS is " + eventID2);
		Long eventID3 = CD.addEvent("6/23/2016", "William", "email3@domain.com", "(858) 123-4569", "125 Fake Street, San Diego, CA 91219", "Test notes");
		System.err.println("Added entry new IS is " + eventID3);
		
		
		Event results = (Event) CD.getEventByDate("6/22/2016");
		System.err.println("Results\nID:" + results.getEventId() + "\nDate: " + results.getDate() + "\nName: "  + results.getName() + "\nEmail: "  + results.getEmail() + "\nPhone: "  + results.getPhone() + "\nAddress: "  + results.getLkAddress().getAddress() + "\nNotes: "  + results.getNotes());
	
	
		results = (Event) CD.getEventByID(3);
		System.err.println("Results\nID:" + results.getEventId() + "\nDate: " + results.getDate() + "\nName: "  + results.getName() + "\nEmail: "  + results.getEmail() + "\nPhone: "  + results.getPhone() + "\nAddress: "  + results.getLkAddress().getAddress() + "\nNotes: "  + results.getNotes());
	
		
	
	}

}
