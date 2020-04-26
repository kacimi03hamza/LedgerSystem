package com.mediasoft.odeks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, 
		DataSourceTransactionManagerAutoConfiguration.class,HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,SecurityAutoConfiguration.class,SecurityFilterAutoConfiguration.class,WebMvcAutoConfiguration.class})
@ComponentScan({"com.mediasoft.odeks.web","com.mediasoft.odeks.repositories,com.mediasoft.odeks.config,com.mediasoft.odeks.services,com.mediasoft.odeks.web"})
@ImportResource({"classpath*:applicationContext.xml"})
@EnableWebSecurity(debug = false)
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OdeksApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdeksApplication.class, args);
	}
	
}
