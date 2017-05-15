package com.radiantshub.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.radiantshub.configurations.AppConfig;
import com.radiantshub.configurations.HibernateConfiguration;

public class SpringConfigurationTestCases {

	
	AnnotationConfigApplicationContext ctx = null;
	
	/**
	 * Here all your static declaration
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * Instance declaration
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class, HibernateConfiguration.class);
	}

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	/**
	 * Testing AnnotationConfigApplicationContext is not null 
	 * 
	 */
	@Test
	public void testHibernateConfiguration(){
		
		Assert.assertEquals(true, ctx!=null);
	}
	
	/**
	 * Testing session factory not null
	 */
	@Test
	public void testSessionFactoryNotNull(){
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		
		Assert.assertEquals(true, sessionFactory!=null);
	}

	
}
