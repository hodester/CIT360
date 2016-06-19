package MissionaryCal;
/**
*
* @author Peter Wong
* @description Calendar Database module for missionary calendar application
* @notes This contain 5 functions which are addEvent, getEvent, updateEvent, removeEvent, and DBConnect
*/

import java.util.List;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CalDB {

	private static SessionFactory factory;
	
	public static void connectDB(){
		try{
	         factory = new Configuration().configure().buildSessionFactory();

	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		
		
	}

	public long addEvent(String eventDate, String memberName, String memberEmail, String memberPhone, String memberAddress, String notes) {
		Session session = factory.openSession();
		Transaction tx = null;
		long eventID = 0;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date oDate = null;
		Address address = null;
		try {
			oDate = df.parse(eventDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		
	    try{
	    	tx = session.beginTransaction();
	    	Event event = new Event();
	    	
	    	System.err.println("Checking for Address record...");
	    	address = (Address) session.createQuery("FROM Address Where address = :memberAddress").setParameter("memberAddress", memberAddress).uniqueResult();

	        
	        if (address == null){
	        	
	        System.err.println("Address record not found, inserting a new one...");
	        address = new Address();
	    	address.setAddress(memberAddress);	
	    	session.save(address);	
	        }

	       
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	event.setDate(oDate);
	    	event.setName(memberName);
	    	event.setEmail(memberEmail);
	    	event.setPhone(memberPhone);
	    	event.setAddress(address);
	    	event.setNotes(notes);
	    	
	    	
	    	session.save(event); 

	    	
	    	eventID = event.getEventId();
	    	tx.commit();

	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	    		e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	
	return eventID;

	}
	
	public Object getEventByDate(String eventDate){
		Session session = factory.openSession();
		Transaction tx = null;
		Event event = null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date oDate = null;
		try {
			oDate = df.parse(eventDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("from Event where eventDate = :date"); 
			List<?> events = query.setParameter("date", oDate).list();
			event = (Event)events.get(0);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			}finally {
				session.close(); 
			}
		return event;
	}

	public Object getEventByID(long eventID){
		Session session = factory.openSession();
		Transaction tx = null;
		Event event = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("from Event where id = :id"); 
			@SuppressWarnings("unchecked")
			List<Event>  events = (List<Event>) query.setParameter("id", eventID).list();
			event = (Event)events.get(0);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			}finally {
				session.close(); 
			}
		return event;
	}	

	public void updateEvent(Integer eventID, Date eventDate, String memberName, String memberEmail, String memberPhone, String memberAddress, String notes){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Event event = session.get(Event.class, eventID); 
			Address address = new Address();
			address.setAddress(memberAddress);
			event.setDate( eventDate );
			event.setName( memberName );
			event.setEmail( memberEmail );
			event.setPhone( memberPhone );
			event.setAddress( address );
			event.setNotes( notes );
			session.update(event); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}

	public void deleteEmployee(Integer eventID){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Event event = session.get(Event.class, eventID); 
			session.delete(event); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}


	    



}
