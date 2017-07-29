package com.sboot.ms.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class DBConnection {
	private static final Logger log= 	LoggerFactory.getLogger(DBConnection.class);
	
	@Value("${database.url}")
	private String dburl;
	
	@Value("${database.userid}")
	private String dbuid;
	
	@Value("${database.password}")
	private String dbpwd;
	
	public void getConnection(){
		log.info("Database url-->"+this.dburl);
		log.info("Database user name-->"+this.dbuid);
		log.info("Database password-->"+this.dbpwd);
		
	}
}
