package com.denizturkmen.Client;

import java.util.Date;

import org.hibernate.Session;

import com.denizturkmen.Entity.Adres;
import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class SaveEmployee {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();

			Employee employee = new Employee();
			employee.setEmployeeName("Deniz TÜRKMEN");
			employee.setDoj(new Date());
			employee.setEmail("turkmen@gmail.com");
			employee.setSalary(455645D);
			
			Employee employee1 = new Employee();
			employee1.setEmployeeName("Eren TÜRKMEN");
			employee1.setDoj(new Date());
			employee1.setEmail("eren@gmail.com");
			employee1.setSalary(752D);

			
			Employee employee2 = new Employee();
			employee2.setEmployeeName("Besra TÜRKMEN");
			employee2.setEmail("besra@gmail.com");
			employee2.setSalary(64564D);
			employee2.setDoj(new Date());
			
			Adres adres = new Adres();
			adres.setCity("Ankara");
			adres.setPincode(7465756L);
			adres.setState("Ümitköy");
			adres.setStreet("Park Caddesi");
			
			employee.setAdres(adres);
			
			Adres adres1 = new Adres();
			adres1.setCity("Ankara");
			adres1.setPincode(7465756L);
			adres1.setState("Ümitköy");
			adres1.setStreet("Park Caddesi");
			
			employee1.setAdres(adres1);
			
			Adres adres2 = new Adres();
			adres2.setCity("Ankara");
			adres2.setPincode(7465756L);
			adres2.setState("Ümitköy");
			adres2.setStreet("Park Caddesi");
			employee2.setAdres(adres2);
			
			
			session.persist(employee);
			session.persist(employee1);
			session.persist(employee2);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
