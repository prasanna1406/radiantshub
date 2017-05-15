/*
 * 
 */
package com.radiantshub.configurations;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.radiantshub.dao.RadiantsRepo;
import com.radiantshub.dao.RadiantsRepoImpl;
import com.radiantshub.entities.IGenericVO;
import com.radiantshub.handler.RadiantsHandler;
import com.radiantshub.handler.RadiantsHandlerImpl;
import com.radiantshub.service.RadiantsService;
import com.radiantshub.service.RadiantsServiceImpl;
import com.radiantshub.util.PropertyUtil;

// TODO: Auto-generated Javadoc
/**
 * Creating a bean which returns the sessionFactory Object with provided connection
 * Datasource Simple implementation of the standard JDBC {@link javax.sql.DataSource} interface,
 * 
 * <p>Useful for test or stand-alone environments outside of a J2EE container, either
 * as a DataSource bean in a corresponding ApplicationContext or in conjunction with
 * a simple JNDI environment. Pool-assuming {@code Connection.close()} calls will
 * simply close the Connection, so any DataSource-aware persistence code should work.
 *
 * @author vivek
 * @DriverManagerDataSource This class is not an actual connection pool; it does not actually pool Connections. 
 * It just serves as simple replacement for a full-blown connection pool, implementing the same standard interface,
 *  but creating new Connections on every call.
 * @BasicDataSource If you need a "real" connection pool outside of a J2EE container, consider Apache's Jakarta Commons DBCP or C3P0. 
 * Commons DBCP's BasicDataSource and C3P0's ComboPooledDataSource are full connection pool beans, 
 * supporting the same basic properties as this class plus specific settings (such as minimal/maximal pool size etc).
 * 
 * Only use the DriverManagerDataSource class should only be used for testing purposes 
 * since it does not provide pooling and will perform poorly when multiple requests for a connection are made.
 */

/*@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.radiantshub.configurations" })
@PropertySource(value = { "classpath:db.properties" })*/
/*@Configuration
@ComponentScan(basePackages = "com.radiantshub")*/
@Configuration
@PropertySource(value = { "classpath:db.properties" })
@EnableTransactionManagement
@ImportResource( "classpath:config/mailHelperMap.xml" )
public class HibernateConfiguration{

	/** The env. */
	@Autowired
	Environment env;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * Session factory.
	 *
	 * @return the local session factory bean
	 * @throws IOException 
	 */
	@Bean
	public SessionFactory sessionFactory() throws IOException{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.radiantshub.entities");
		sessionFactory.setHibernateProperties(getHibernateProperty());
		sessionFactory.afterPropertiesSet();
		return sessionFactory.getObject();
	}

	
	/**
	 * Data source.
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("hibernate.connection.driver_class"));
		dataSource.setUrl(env.getProperty("hibernate.connection.url"));
		dataSource.setUsername(env.getProperty("hibernate.connection.username"));
		dataSource.setPassword(env.getProperty("hibernate.connection.password"));

		return dataSource;
	}

	/**
	 * Transaction manager.
	 *
	 * @param s the s
	 * @return the hibernate transaction manager
	 */
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}

	
	/**
	 * Gets the hibernate property.
	 *
	 * @return the hibernate property
	 */
	private Properties getHibernateProperty(){
		Properties hibernateProperty = PropertyUtil.getProperties("hibernate");
		Properties dbProperty = PropertyUtil.getProperties("db");

		Properties finalHibernateProperties = new Properties();
		finalHibernateProperties.putAll(hibernateProperty);
		finalHibernateProperties.putAll(dbProperty);

		return finalHibernateProperties;

	}

	@Bean
	public RadiantsService<IGenericVO> radiantsService(RadiantsRepo<IGenericVO> radiantsRepo){
		return new RadiantsServiceImpl<IGenericVO>("vivek");
	}
	
	@Bean
	public RadiantsRepo<IGenericVO> radiantsRepo() throws IOException{
		
		return new RadiantsRepoImpl<IGenericVO>(sessionFactory());
	}
	
	@Bean
	public RadiantsHandler radiantsHandler(RadiantsService<IGenericVO> radiantsService){
		
		return new RadiantsHandlerImpl();
	}
	
	@Bean(name = "gmailMailSender")
	public JavaMailSenderImpl getGmailSetting(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost("smtp.gmail.com");
		Properties mailProperties = new Properties();
		mailProperties.put("mail.transport.protocol", "smtp");
		mailProperties.put("mail.smtp.auth", true);
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.debug", true);
		mailSender.setJavaMailProperties(mailProperties);
		mailSender.setUsername("developer3@perennialsys.com");
		mailSender.setPassword("developer@321");
		mailSender.setPort(587);
		
		return mailSender;
	}
	
	@Bean(name="otherMailSender")
	public JavaMailSenderImpl getOtherMailSetting(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost("smtp.gmail.com");
		Properties mailProperties = new Properties();
		mailProperties.put("mail.transport.protocol", "smtp");
		mailProperties.put("mail.smtp.auth", true);
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.debug", true);
		mailSender.setJavaMailProperties(mailProperties);
		mailSender.setUsername("developer3@perennialsys.com");
		mailSender.setPassword("developer@321");
		mailSender.setPort(587);
		
		return mailSender;
	}
}
