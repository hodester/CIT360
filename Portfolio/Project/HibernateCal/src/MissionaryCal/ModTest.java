package MissionaryCal;

/**
*
* @author Peter Wong
* @description This is a test for Calendar Database module
* @notes This will test the 5 functions which are addEvent, getEvent, updateEvent, removeEvent, and DBConnect
*/

public class ModTest {

	public static void main(String[] args) {
		System.err.println("Starting Application\nConnecting to Database using Hibernate\n");
				
		CalDB.connectDB();
		
		System.err.println("\n\n\n\n");

		CalDB CD = new CalDB();
		
		String sampledate = getRandomDate();
		
		Long eventID1 = CD.addEvent(getRandomDate(), "Peter", "Peter@domain.com", "(858) 123-4567", "123 Fake Street, San Diego, CA 91219", "Test notes");
		System.err.println("Added entry new ID is " + eventID1 +"\n");
		
		Long eventID2 = CD.addEvent(sampledate, "Jennifer", "Jennifer@domain.com", "(858) 123-4568", "123 Fake Street, San Diego, CA 91219", "Test notes");
		System.err.println("Added entry new ID is " + eventID2 +"\n");
		
		Long eventID3 = CD.addEvent(getRandomDate(), "Simon", "Simon@domain.com", "(858) 123-4569", "125 Fake Street, San Diego, CA 91219", "Test notes");
		System.err.println("Added entry new ID is " + eventID3 +"\n");
		
		Long eventID4 = CD.addEvent(getRandomDate(), "Theodore", "Theodore@domain.com", "(858) 123-4569", "125 Fake Street, San Diego, CA 91219", "Test notes");
		System.err.println("Added entry new ID is " + eventID4 +"\n");
		
		Long eventID5 = CD.addEvent(getRandomDate(), "Brittany", "Brittany@domain.com", "(858) 123-4569", "125 Fake Street, San Diego, CA 91219", "Test notes");
		System.err.println("Added entry new ID is " + eventID5 +"\n");
		
		Long eventID6 = CD.addEvent(getRandomDate(), "Jeanette", "Jeanette@domain.com", "(858) 123-4569", "125 Fake Street, San Diego, CA 91219", "Test notes");
		System.err.println("Added entry new ID is " + eventID6 +"\n");

		
		
		Event results = (Event) CD.getEventByDate(sampledate);
		System.err.println("Results\nID:" + results.getEventId() + "\nDate: " + results.getDate() + "\nName: "  + results.getName() + "\nEmail: "  + results.getEmail() + "\nPhone: "  + results.getPhone() + "\nAddress: "  + results.getAddress().getAddress() + "\nNotes: "  + results.getNotes() +"\n");
	
	
		results = (Event) CD.getEventByID(eventID1);
		System.err.println("Results\nID:" + results.getEventId() + "\nDate: " + results.getDate() + "\nName: "  + results.getName() + "\nEmail: "  + results.getEmail() + "\nPhone: "  + results.getPhone() + "\nAddress: "  + results.getAddress().getAddress() + "\nNotes: "  + results.getNotes() +"\n");
	
		System.err.println("Deleting record " + eventID4 + "\n");
		CD.deleteEventByID(eventID4);
		
		Long eventIDupdate = CD.updateEventByID(eventID1,getRandomDate(), "Peter Wong", "Peter@domain.com", "(858) 123-4567", "123 Fake Street, San Diego, CA 91219", "Test notes");
		System.err.println("Updated entry ID: " + eventIDupdate +"\n");
		
		results = (Event) CD.getEventByID(eventIDupdate);
		System.err.println("Results\nID:" + results.getEventId() + "\nDate: " + results.getDate() + "\nName: "  + results.getName() + "\nEmail: "  + results.getEmail() + "\nPhone: "  + results.getPhone() + "\nAddress: "  + results.getAddress().getAddress() + "\nNotes: "  + results.getNotes() +"\n");
		

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
