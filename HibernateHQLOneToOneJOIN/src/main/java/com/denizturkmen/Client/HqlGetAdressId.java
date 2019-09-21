package com.denizturkmen.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Adres;
import com.denizturkmen.Util.HibernateUtil;

public class HqlGetAdressId {

	public static void main(String[] args) {
		getEmployeeAndAdressById();
	}

	private static void getEmployeeAndAdressById() {
		
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			//String HQL="FROM Adres adr LEFT JOIN JOIN FETCH adr.employee WHERE adr.adresId=:adressID";

	    	String HQL="FROM Adres adr LEFT OUTER JOIN FETCH adr.employee WHERE adr.adresId=:adresID";
	    	Adres address = session.createQuery(HQL, Adres.class).setParameter("adresID", 1).uniqueResult();
	    	
	    	System.out.println(address);
	    	//System.out.println(address.getEmployee());
		} 
	    catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
}
