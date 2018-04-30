package com.javatpoint.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.SessionFactory;


public class Manager {
	private static SessionFactory factory = (SessionFactory) Persistence.createEntityManagerFactory( "test" );
	   
//	   public static void main(String args[]) {
//		   factory = (SessionFactory) Persistence.createEntityManagerFactory( "test" );
//		   listEmployees();
//	   }
//	   
	   @SuppressWarnings("unchecked")
	public static List<Employee> listEmployees() {
		   EntityManager entityManager = factory.createEntityManager();
		   List<Employee> emp = null;
		   EntityTransaction tx = null;
		   try {
			   tx = entityManager.getTransaction();
			   String hql = "From Employee";
			   tx.begin();
			   Query query = entityManager.createQuery(hql);
			   emp = query.getResultList();
			   tx.commit();
		   } catch (Exception e) {
			   if(tx!=null)
				   tx.rollback();
		   } finally {
			   entityManager.close();
		   }
		   return emp;
	   }

	public static void addEmployee(String name,int salary, String city, String state, int pincode) {
		   Address address = new Address(city,state,pincode);
		   Employee emp = new Employee(name,salary);
		   EntityManager entityManager = factory.createEntityManager();
		   EntityTransaction tx = null;
		   emp.setAddress(address);
		   try {
			   tx = entityManager.getTransaction();
			   tx.begin();
			   entityManager.persist(emp);
			   tx.commit();
		   } catch (Exception e) {
			   System.out.println("Error in Manager: "+ e);
			   if(tx!=null)
				   tx.rollback();
		   } finally {
			   entityManager.close();
		   }
		   
	   }
	   
	   public static void deleteEmployee(Integer id) {
		   EntityManager entityManager = factory.createEntityManager();
		   EntityTransaction tx = null;
		   try {
			   tx = entityManager.getTransaction();
			   tx.begin();
			   Employee emp = entityManager.find(Employee.class,id);
			   entityManager.remove(emp);
			   tx.commit();
		   } catch (Exception e) {
			   System.out.println("Error in Manager: "+ e);
			   if(tx!=null)
				   tx.rollback();
		   } finally {
			   entityManager.close();
		   }
	   }
	   
	   public static void updateEmployee(Integer id, int salary) {
		   EntityManager entityManager = factory.createEntityManager();
		   EntityTransaction tx = null;
		   try {
			   tx = entityManager.getTransaction();
			   tx.begin();
			   Employee emp = entityManager.find(Employee.class,id);
			   emp.setSalary(salary);
			   entityManager.merge(emp);
			   tx.commit();
		   } catch (Exception e) {
			   System.out.println("Error in Manager: "+ e);
			   if(tx!=null)
				   tx.rollback();
		   } finally {
			   entityManager.close();
		   }
	   }
}