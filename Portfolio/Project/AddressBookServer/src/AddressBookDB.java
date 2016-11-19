/**
*
* @author Peter Wong
* @description Calendar Database module for missionary calendar application
* @notes This contain 5 functions which are addEvent, getEvent, updateEvent, removeEvent, and DBConnect
*/

import java.util.List;
import java.util.Set;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddressBookDB {

	private static SessionFactory factory;
	
	public static void connectDB(){
		try{
	         factory = new Configuration().configure().buildSessionFactory();

	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		
		
	}

	public long addPerson(String pName, String dob, String pEmail, String pPhone, Address pAddress) {
		Session session = factory.openSession();
		Transaction tx = null;
		long personID = 0;

		Address address = null;
		
	    try{
	    	tx = session.beginTransaction();
	    	Person person = new Person();
	    	
	    	// Check if Address already exist
	    	
	    	Query query = session.createQuery("FROM Address Where street = :street and city = :city and state = :state and zip = :zip");
	    	query.setParameter("street", pAddress.getStreet());
	    	query.setParameter("city", pAddress.getCity());
	    	query.setParameter("state", pAddress.getState());
	    	query.setParameter("zip", pAddress.getZip());
	    	address = (Address) query.uniqueResult();
	        
	        if (address == null){
	        // Address is new
	        	System.err.println("Adding new address\n");
	        	address = new Address();
		    	address.setStreet(pAddress.getStreet());	
		    	address.setCity(pAddress.getCity());	
		    	address.setState(pAddress.getState());	
		    	address.setZip(pAddress.getZip());	
		    	session.save(address);	
	        }
	        else{
	        	System.err.println("Address already exist" + address + "\n");
	        	
	        }
	        
	        Set<Address> addresses = new HashSet<Address>();
	        addresses.add(address1);
	        addresses.add(address2);
	        person.setAddresses(addresses);
	        
	        person.setAddress(address);
	        person.setDob(convertDate(dob));
	        person.setName(pName);
	        person.setEmail(pEmail);
	        person.setPhone(pPhone);



	    	session.save(person); 

	    	personID = person.getPersonId();
	    	tx.commit();

	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	    		e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	
	return personID;

	}
	
	public Object getPersonByName(String name){
		Session session = factory.openSession();
		Transaction tx = null;
		Person person = null;

		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("from Person where name = :name"); 
			List<?> events = query.setParameter("name", name).list();
			person = (Person)events.get(0);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			}finally {
				session.close(); 
			}
		return person;
	}

	public Object getPersonByID(long eventID){
		Session session = factory.openSession();
		Transaction tx = null;
		Person event = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("from Person where id = :id"); 
			@SuppressWarnings("unchecked")
			List<Person>  events = (List<Person>) query.setParameter("id", eventID).list();
			event = (Person)events.get(0);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			}finally {
				session.close(); 
			}
		return event;
	}	

	public Long updatePersonByID(Long id, String pName, String dob, String pEmail, String phone, Address pAddress){
		Session session = factory.openSession();
		Transaction tx = null;
		Address address = null;
		try{
			tx = session.beginTransaction();
			Person person = session.get(Person.class, id); 

	    	// Check if Address already exist
	    	Query query = session.createQuery("FROM Address Where street = :street and city = :city and state = :state and zip = :zip");
	    	query.setParameter("street", pAddress.getStreet());
	    	query.setParameter("city", pAddress.getCity());
	    	query.setParameter("state", pAddress.getState());
	    	query.setParameter("zip", pAddress.getZip());
	    	address = (Address) query.uniqueResult();
	        
	        if (address == null){
	        // Address is new
	        	System.err.println("Adding new address\n");
	        	address = new Address();
		    	address.setStreet(pAddress.getStreet());	
		    	address.setCity(pAddress.getCity());	
		    	address.setState(pAddress.getState());	
		    	address.setZip(pAddress.getZip());	
		    	session.save(address);	
	        }
	        else{
	        	System.err.println("Address already exist" + address + "\n");
	        	
	        }
	    	
	        person.setName(pName);
	        person.setDob(convertDate(dob));
	        person.setEmail(pEmail);
	        person.setPhone(phone);
	        person.setAddress(address);

	    	
			session.update(person); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return id;
	}

	public int deletePersonByName(String name){
		Session session = factory.openSession();
		Transaction tx = null;
		int result = 0;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("delete Person where name = :name"); 
			query.setParameter("name", name);
			result = query.executeUpdate();
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		
		return result;
	}

	public void deletePersonByID(Long personID){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Person event = session.get(Person.class, personID);
			session.delete( event); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}

	 public Date convertDate(String sdate){
		 
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date oDate = null;
			try {
				oDate = df.parse(sdate);
			} catch (ParseException e) {
				
				e.printStackTrace();
			} 
			
			return oDate;
		 
	 }



}
