package com.stackroute.muzix.config;


import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*config for h2-console*/
@Configuration
public class WebConfig {
	
	//	creates bean for ServletRegistrationBean
	@Bean
	ServletRegistrationBean h2ServletRegistrationBean(){
//		creates new WebServlet and inject in ServletRegistrationBean and add url for it
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}