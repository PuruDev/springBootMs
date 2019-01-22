package com.sboot.ms.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@ComponentScan({"com.sboot.ms.controller","com.sboot.ms.service", "com.sboot.ms.repository", "com.sboot.ms.utility"})
public class MavenProfileMicroservice {
	
private static final Logger log= 	LoggerFactory.getLogger(MavenProfileMicroservice.class);
	

//	@Value("${server.port}")
//	private String serverPort;
//	
	@Value("#{dbProperties['database.deploy.url']}")
	private String dburl;
//	
//	@Value("${database.deploy.userid}")
//	private String dbuid;
//	
//	@Value("${database.deploy.password}")
//	private String dbpwd;


	@Bean
	PropertiesFactoryBean dbProperties (){
		PropertiesFactoryBean pfactoryBean = new PropertiesFactoryBean();
		pfactoryBean.setLocation(new ClassPathResource("application.properties"));
		return pfactoryBean;
	}
	
	
	
	public static void main(String[] str) {
		MavenProfileMicroservice mms = new MavenProfileMicroservice();
		log.info("DB url in maven profile ms-->"+mms.dburl);
		SpringApplication.run(MavenProfileMicroservice.class, str);
		mms.getDbUrl();
		
	}
	
	private void getDbUrl(){
		System.out.println("DB url after build-->"+this.dburl);
	}

}
