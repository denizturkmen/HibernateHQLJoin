package com.denizturkmen.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.denizturkmen.Entity.Adres;
import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class HqlGetEmployeeId {
	public static void main(String[] args) {
		getEmployeeAndAdressByEmployeeId();
	}

	private static void getEmployeeAndAdressByEmployeeId() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String HQL = "FROM Employee emp LEFT JOIN FETCH emp.adres WHERE emp.employeeId=:empId";
			Query<Employee> query = session.createQuery(HQL);
			query.setParameter("empId", 1);
			
			Employee employee = query.uniqueResult();
			System.out.println(employee);
			
			Adres adres = employee.getAdres();
			System.out.println(adres);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
