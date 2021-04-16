package springbootbackendapirestcurriculum.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/personas", "/images/**", "/api/personas/uploads/img/**").permitAll()
		/*
		.antMatchers(HttpMethod.GET, "/api/personas/{id}").hasRole("USER")
		//.antMatchers(HttpMethod.POST, "/api/personas").permitAll()
		.antMatchers(HttpMethod.PUT, "/api/personas/{id}").hasRole("USER")
		//.antMatchers(HttpMethod.DELETE, "/api/personas/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api/personas/upload").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/api/personas/uploads/img/**").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/api/conocimientos").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/api/conocimientos/{id}").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/api/conocimientos/{id}").hasRole("USER")
		.antMatchers(HttpMethod.PUT, "/api/conocimientos/{id}").hasRole("USER")
		.antMatchers(HttpMethod.DELETE, "/api/conocimientos/{id}").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/api/conocimientos/tecnologias").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/api/estudios").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/api/estudios/{id}").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/api/estudios/{id}").hasRole("USER")
		.antMatchers(HttpMethod.PUT, "/api/estudios/{id}").hasRole("USER")
		.antMatchers(HttpMethod.DELETE, "/api/estudios/{id}").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/api/experiencias").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/api/experiencias/{id}").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/api/experiencias/{id}").hasRole("USER")
		.antMatchers(HttpMethod.PUT, "/api/experiencias/{id}").hasRole("USER")
		.antMatchers(HttpMethod.DELETE, "/api/experiencias/{id}").hasRole("USER")
		*/
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return bean;
	}

}
