package com.stormpath.idsite_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.crossover.ishim.controllers.AppErrorController;
import com.crossover.ishim.controllers.SecurityController;

@Configuration
public class WebResourceResolver extends WebMvcConfigurerAdapter {
	
	@Autowired
	 private ErrorAttributes errorAttributes;
	
    @Value("#{ @environment['stormpath.template.root'] ?: 'ix' }")
    private String templateRoot;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/public/" + templateRoot + "/");
    }

    @Bean
    public ClassLoaderTemplateResolver templateResolver() {
        ClassLoaderTemplateResolver resolver  = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/" +templateRoot + "/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1);
        return resolver;
    }
    
    @Bean
    public AppErrorController appErrorController(){
    	return new AppErrorController(errorAttributes);
    }
    
    @Bean
    public SecurityController securityController(){
		return new SecurityController();
    	
    }
}
