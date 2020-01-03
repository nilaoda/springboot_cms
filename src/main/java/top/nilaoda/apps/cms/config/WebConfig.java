package top.nilaoda.apps.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
				.addMapping("/**")
				//.allowedOrigins("*")
				.allowedOrigins("http://localhost:9527")
				.allowedMethods("GET","POST","PUT","OPTIONS","DELETE","PATCH")
				.allowCredentials(true).maxAge(3600);
	}
	
}
