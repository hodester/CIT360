package AddressBook.model;
/**
*
* @author Peter Wong
*/

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import AddressBook.model.Person;


public class HibernateDB {

	private static SessionFactory factory;
	
	public static void connectDB(){
		try{
	         factory = new Configuration().configure().buildSessionFactory();

	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		
		
	}

	public long addPerson(String name, String email, String phone, String address) {
		Session session = factory.openSession();
		Transaction tx = null;
		long PersonID = 0;

	    try{
	    	tx = session.beginTransaction();
	    	Person person = new Person();
	    	

	    	person.setName(name);
	    	person.setEmail(email);
	    	person.setPhone(phone);
	    	person.setAddress(address);


	    	session.save(person); 

	    	PersonID = person.getPersonId();
	    	tx.commit();

	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	    		e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	
	return PersonID;

	}
	
	public Object getPersonByName(String name){
		Session session = factory.openSession();
		Transaction tx = null;
		Person person = null;

		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("from Person where name = :name"); 
			query.setParameter("name", name);
			
			@SuppressWarnings("unchecked")
			List<Person> persons  = query.list();
			
			if(!persons.isEmpty()){
			    // ignores multiple results
				person = (Person) persons.get(0);

			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			}finally {
				session.close(); 
			}
		return person;
	}

	public Object getPersonByID(long personID){
		Session session = factory.openSession();
		Transaction tx = null;
		Person person = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("from Person where id = :id"); 
			query.setParameter("id", personID);
			
			@SuppressWarnings("unchecked")
			List<Person> persons  = query.list();
			
			if(!persons.isEmpty()){
			    // ignores multiple results
				person = (Person) persons.get(0);

			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			}finally {
				session.close(); 
			}
		return person;
	}	
	@SuppressWarnings("unchecked")
	public Object getPersons(){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Person> persons = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("From Person ORDER BY name"); 
			
			persons  = query.list();
			
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
			}finally {
				session.close(); 
			}
		return persons;
	}	
	public Long updatPersonByID(Long id, String name, String email, String phone, String address){
		Session session = factory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			Person person = session.get(Person.class, id); 
			person.setName(name);
			person.setEmail(email);
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

	public Long deletePersonByID(Long personID){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Person person = session.get(Person.class, personID);
			session.delete( person); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
				e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return personID;
	}

}
