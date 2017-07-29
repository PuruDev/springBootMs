package com.sboot.ms.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sboot.ms.utility.DBConnection;

@SpringBootApplication
//@ComponentScan(basePackageClasses = EmployeeController.class)
@ComponentScan({"com.sboot.ms.controller","com.sboot.ms.service", "com.sboot.ms.repository"})
public class FirstMicroservices implements CommandLineRunner{
	
	private static final Logger log= 	LoggerFactory.getLogger(FirstMicroservices.class);
	
	public static void main(String[] str) {
		SpringApplication.run(FirstMicroservices.class, str);
	}
	
	@Value("${server.port}")
	private String serverPort;
	
	@Value("${database.url}")
	private String dburl;
	
	@Value("${database.userid}")
	private String dbuid;
	
	@Value("${database.password}")
	private String dbpwd;

	@Override
	public void run(String... arg0) throws Exception {
		log.info("server port-->"+this.serverPort);
		
		log.info("DB in MS url-->"+this.dburl);
		log.info("DB in MS userid-->"+this.dbuid);
		log.info("DB in MS password-->"+this.dbpwd);
		
		DBConnection connection = new DBConnection();
		connection.getConnection();
	} 
	
	
}
