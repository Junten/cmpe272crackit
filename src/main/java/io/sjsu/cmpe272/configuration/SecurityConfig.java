package io.sjsu.cmpe272.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@EnableOAuth2Sso  
@Configuration
@EnableWebSecurity
@PropertySource("classpath:mysql-query.properties")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override  
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
        http.authorizeRequests().antMatchers("/login").permitAll();
        
        http.authorizeRequests().antMatchers("/home").hasAnyAuthority("Admin", "User");

        http.authorizeRequests().and().logout()
        	.invalidateHttpSession(true)
    		.clearAuthentication(true)
    		.logoutSuccessUrl("/")
    		.deleteCookies("JSESSIONID");
    		
    }

    @Autowired
    private DataSource dataSource;
//
//    @Value("${spring.queries.users-query}")
//    private String usersQuery;
//
//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;
//    

//    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//            .usersByUsernameQuery(usersQuery)
//            .authoritiesByUsernameQuery(rolesQuery)
//            .dataSource(dataSource)
//            .passwordEncoder(bCryptPasswordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	
//    	http.csrf().disable();
//    	
//    	
//    	 
//        http.authorizeRequests().antMatchers("/home").hasAnyRole("USER", "ADMIN");
//        
//        http.authorizeRequests().antMatchers("/home/allusers/**").hasRole("ADMIN");
//        
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403Page");
//        
//        http.authorizeRequests().and().formLogin()
//        	.loginPage("/login")
//        	.failureUrl("/login?error=true")
//        	.defaultSuccessUrl("/home/{username}")
//        	.usernameParameter("username")
//            .passwordParameter("password");
//        
        
//    }
//
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
    
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

}

