package com.example.proyectoscp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class configuration {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry
		 	.addResourceHandler("/resources/**")
		 	.addResourceLocations("/resources/**");
		 
	 }
	 
	/*@Bean
    public ClassLoaderTemplateResolver yourTemplateResolver() {
        ClassLoaderTemplateResolver configurer = new ClassLoaderTemplateResolver();
        configurer.setPrefix("templates/");
        configurer.setSuffix(".html");
        configurer.setTemplateMode(TemplateMode.HTML);
        configurer.setCharacterEncoding("UTF-8");
        configurer.setOrder(0);  // this is important. This way spring //boot will listen to both places 0 and 1
        configurer.setCacheable(false);
        configurer.setCheckExistence(true);
        return configurer;
    }*/
	
}
