package org.vaibhavi.webapps.telenotes.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.vaibhavi.webapps.telenotes.model.CompanyContact;
import org.vaibhavi.webapps.telenotes.model.User;


public class CompanyContactService {
	
	//public static SessionFactory sessionFactory = new Configuration().configure(new File("D:/2018/workspace/telenotes/src/hibernate.cfg.xml")).buildSessionFactory();
	//public static SessionFactory sessionFactory = new Configuration().configure(new File("D:/2018/workspace/telenotes/src/hibernate.cfg.xml")).buildSessionFactory();
	
		
	//This is just for initial testing, do not expose session to be static variable. 
	//Close the connection and create different sessions as required
	public static Session session = new Configuration().configure(new File("D:/2018/workspace/telenotes/src/hibernate.cfg.xml")).buildSessionFactory().openSession();
	public CompanyContact companyRecord;
	
	public List<CompanyContact> getAllCompanyContacts() {
		
		//USE OF HQL TO FETCH ALL THE SQL QUERIES
		/*List<CompanyContact> list = new ArrayList<CompanyContact>();
		
		CompanyContact c1 = new CompanyContact("netflix");
		CompanyContact c2 = new CompanyContact("uber");
		CompanyContact c3 = new CompanyContact("dropbox");
		CompanyContact c4 = new CompanyContact("lyft");
		CompanyContact c5 = new CompanyContact("pinterest");
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);*/
				
		
		session.beginTransaction();
		Query query = session.createQuery("from CompanyContact");
		List contacts = query.list();
		session.getTransaction().commit();
		System.out.println("SIZE OF THE LIST :" + contacts.size());
		
		return contacts;
		
	}

	public CompanyContact addCompanyContact(CompanyContact companyContact) {
		System.out.println(" FROM SERVICE METHOD TO ADD CONTACT :");  
		return addCompanyContactToDatabase(companyContact);
					
	}
	
	public CompanyContact updateCompanyContact(CompanyContact companyContact) {
		System.out.println("FROM SERVICE CLASS - UPDATE METHOD");
		return updateCompanyContactInDatabase(companyContact);

	}
	
	public boolean deleteCompanyContact(String companyNameToDelete) {
		
		System.out.println("FROM SERVICE CLASS - DELETE METHOD");
		CompanyContact companyContact = (CompanyContact)session.get(CompanyContact.class, companyNameToDelete);
		
		return deleteCompanyContactFromDatabase(companyContact);
	}
	
/*	This method will be obsolete as we only need list of all contacts for view
	Unless changed to dto method
	public CompanyContact getCompanyContactFromDatabase(CompanyContact companyContact) {
		
		try{		
			companyRecord = (CompanyContact) session.get(CompanyContact.class, companyContact.getCompanyName());						
			
		} catch (Exception e) {
	        System.out.println(e.getStackTrace());
	        session.getTransaction().rollback();
	    }
		return companyRecord;
	}*/
		
	public CompanyContact addCompanyContactToDatabase(CompanyContact companyContact) {

		try{
			session.beginTransaction();
			session.save(companyContact);
			session.getTransaction().commit();
			companyRecord = (CompanyContact) session.get(CompanyContact.class, companyContact.getCompanyName());
			//session.close();
		} 
		
		catch (Exception e) {
	        System.out.println(e.getStackTrace());
	        session.getTransaction().rollback();
	    }
		
        System.out.println("FROM SERVICE CLASS DTO METHOD: ");
        System.out.println(companyRecord.getCompanyName());
        System.out.println(companyRecord.getContactName());
		return companyRecord;
		
	}
	
	public CompanyContact updateCompanyContactInDatabase(CompanyContact companyContact) {
		
		try {	
			session.beginTransaction();
			companyRecord = (CompanyContact)session.get(CompanyContact.class, companyContact.getCompanyName());
			
			companyRecord.setCompanyName(companyContact.getCompanyName());
			companyRecord.setContactName(companyContact.getContactName());
			companyRecord.setPhoneNumber(companyContact.getPhoneNumber());
			
			session.update(companyRecord);
			session.getTransaction().commit();
			//session.close();
			
		} catch(RuntimeException re){
			
			System.out.println(re.getStackTrace());
	        session.getTransaction().rollback();
	        return null;
	        
		}
		return ((CompanyContact)session.get(CompanyContact.class, companyContact.getCompanyName()));		
		
	}
	
	public boolean deleteCompanyContactFromDatabase(CompanyContact companyContact) {
		try {
			
			session.beginTransaction();
			session.delete(companyContact);
			session.getTransaction().commit();
			//session.close();
		} catch(RuntimeException re){
			System.out.println(re.getStackTrace());
	        session.getTransaction().rollback();
	        return false;
		}
		return true;
		
	}
	
}
