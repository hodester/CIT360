package com.hibernate.tutorial.mainclass;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.tutorial.entity.Employee;

public class Hibernate5InsertTest {

 public static void main(String[] args) {
  SessionFactory sessionFactory;
  sessionFactory = new Configuration().configure().buildSessionFactory();

  Session session = sessionFactory.openSession();

  Transaction tx = session.beginTransaction();

  //Generate a random ID
  Random rand = new Random(); 
  int value = rand.nextInt(10000); 
  
  Employee emp = new Employee();
  emp.setId(new Long(value));
  emp.setEmployeeName("Peter Wong");
  emp.setEmployeeAddress("San Diego, California");
  session.save(emp);
  
  
  value = rand.nextInt(10000); 
  
  Employee emp2 = new Employee();
  emp2.setId(new Long(value));
  emp2.setEmployeeName("User1");
  emp2.setEmployeeAddress("San Diego, California");
  session.save(emp2);
  
  
  tx.commit();
  
  session.close();
 }
}