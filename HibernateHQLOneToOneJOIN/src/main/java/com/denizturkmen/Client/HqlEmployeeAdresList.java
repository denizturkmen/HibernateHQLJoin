package com.denizturkmen.Client;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.denizturkmen.Util.HibernateUtil;

public class HqlEmployeeAdresList {
	public static void main(String[] args) {

		getEmployeeList();
	}

	private static void getEmployeeList() {

	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	String HQL="SELECT emp.employeeName,emp.doj,emp.salary,addr.city,addr.pincode "
	    			+ "FROM Employee emp LEFT JOIN  emp.adres addr WHERE  emp.employeeId=:empId";
	    	 Query<Object[]> query = session.createQuery(HQL);
	    	 query.setParameter("empId", 2);
	    	 List<Object[]> list = query.list();
	    	
	    	 for (Object[] objects : list) {
				String employeeName =(String)objects[0];
				Date doj=(Date)objects[1];
				Double sal =(Double)objects[2];
				String city=(String)objects[3];
				Long pincode=(Long)objects[4];
				
				System.out.println(employeeName+"\t"+doj+"\t"+sal+"\t"+city+"\t"+pincode);
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
