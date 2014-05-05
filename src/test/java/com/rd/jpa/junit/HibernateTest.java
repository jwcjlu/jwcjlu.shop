package com.rd.jpa.junit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import com.mysql.jdbc.CallableStatement;
import com.rd.jpa.entity.PersonEntity;
import com.rd.jpa.util.HibernateUtil;

public class HibernateTest {
	 @Test  
	    public void testGetSession() {  
	        Session session = HibernateUtil.getSession();  
	          
	        Assert.assertNotNull(session);  
	          
	        HibernateUtil.closeSession();  
	    }  
	      
	    @Test  
	    public void testSave() {  
	        PersonEntity person = new PersonEntity();  
	        person.setName("模式");  
	        Session session = HibernateUtil.getSession();  
	        Transaction tx = session.beginTransaction();  
	        session.save(person);
	        tx.commit();  
	        HibernateUtil.closeSession();  
	    }  
	      
	    @Test  
	    public void testQuery() {  
	        Session session = HibernateUtil.getSession();  
	        session.beginTransaction();  
	          
	        @SuppressWarnings("unchecked")  
	        List<PersonEntity> personList = session.createQuery("select p from PersonEntity p").list();  
	          
	        for(PersonEntity eachPerson : personList) {  
	            System.out.println(eachPerson);  
	        }  
	          
	        session.getTransaction().commit();  
	        HibernateUtil.closeSession();  
	    }  
	      @Test
	      public void testProcedure() throws SQLException{
	    	  Session session=HibernateUtil.getSession();
	    	  CallableStatement callableStatement =(CallableStatement) session.connection().prepareCall("call proc_name(?)");
	    	  callableStatement.setInt(1,0);
	    	  callableStatement.execute();
	    	  ResultSet rs=(ResultSet) callableStatement.getObject(1);
	    	
	      }

}
