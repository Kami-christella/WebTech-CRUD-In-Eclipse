
package DAO;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.SharedSessionContract;
import org.hibernate.query.QueryProducer;
import org.hibernate.Session;
//import com.mysql.cj.Session;

import Model.PersonModel;
import util.HibernateUtil;

import java.util.*;


public class Person {

	public static PersonModel registerPerson(PersonModel obj) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        org.hibernate.Transaction transaction = session.beginTransaction();
	        session.save(obj);
	        transaction.commit();
	        return obj;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}

	
	
	
//	public static PersonModel registerPerson(PersonModel obj) {
//	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//	        Transaction transaction = (Transaction) session.beginTransaction();
//	        session.save(obj);
//	        transaction.commit();
//	        return obj;
//	    } catch (Exception ex) {
//	        ex.printStackTrace();
//	    }
//	    return null;
//	}

	
	
	   
//	   public static List<PersonModel> allPeople(){
//	         try{
//	             Session ss=(Session) HibernateUtil.getSessionFactory().openSession();
//	             List<PersonModel> obj= ((QueryProducer) ss).createQuery("select theperson from customers theperson").list();
//	         ss.forceClose();
//	         return obj;
//	         }catch(Exception ex){
//	             ex.printStackTrace();
//	         }
//	         return null;
//	     }
	   
	   
	   
//	   public static PersonModel searchPerson(int id){
//	        try{
//	            Session ss = (Session) HibernateUtil.getSessionFactory().openSession();
//	            PersonModel one = (PersonModel)((org.hibernate.Session) ss).get(PersonModel.class, id.getId());
//	            ss.forceClose();
//	            return one;
//	        }catch(Exception ex){
//	            ex.printStackTrace();
//	        }
//	        return null;
//	    }
	
	public static PersonModel updatePerson(PersonModel obj) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction transaction = (Transaction) session.beginTransaction();
	        session.update(obj);
	        transaction.commit();
	        return obj;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	   public static int deletePerson(int id){
	        try{
	            Session ss = (Session) HibernateUtil.getSessionFactory().openSession();
	            ((org.hibernate.Session) ss).delete(id);
	            ((SharedSessionContract) ss).beginTransaction().commit();
	            ((SharedSessionContract) ss).close();
	            return id;
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        return (Integer) null;
	    }
	   public List<PersonModel> allPeople(){
	         try{
	             Session ss=HibernateUtil.getSessionFactory().openSession();
	             List<PersonModel> theEmployees=ss.createQuery("select theEmployee from PersonModel theEmployee").list();
	        ss.close();
	        return theEmployees;
	         }catch(Exception ex){
	             ex.printStackTrace();
	         }
	         return null;
	     }
	   public PersonModel searchPerson(PersonModel employeeObj){
	        try{
	            Session ss = HibernateUtil.getSessionFactory().openSession();
	            PersonModel theEmployees = (PersonModel)ss.get(PersonModel.class, employeeObj.getId());
	            ss.close();
	            return theEmployees;
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        return null;
	    }
	  
	   
}
