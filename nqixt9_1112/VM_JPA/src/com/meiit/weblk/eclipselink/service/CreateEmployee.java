package com.meiit.weblk.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.meiit.webalk.eclipselink.entity.Employee;

public class CreateEmployee 
{
	public static void main( String[ ] args ) 
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "VM_JPA" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Employee employee = new Employee( ); 
		employee.setEid( 321 );
		employee.setEname( "Valami" );
		employee.setSalary( 124000 );
		employee.setDeg( "Technical Manager" );
		entitymanager.persist( employee );
		entitymanager.getTransaction( ).commit( );
		
		entitymanager.close( );
		emfactory.close( );
	}
}