package com.sboot.ms.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class DBConnection {
	private static final Logger log= 	LoggerFactory.getLogger(DBConnection.class);
	
	@Value("${database.deploy.url}")
	private String dburl;
	
	@Value("${database.deploy.userid}")
	private String dbuid;
	
	@Value("${database.deploy.password}")
	private String dbpwd;
	
	public void getConnection(){
		log.info("Database url-->"+this.dburl);
		log.info("Database user name-->"+this.dbuid);
		log.info("Database password-->"+this.dbpwd);
		
	}
}
