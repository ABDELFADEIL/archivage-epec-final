package org.simplon.epec.archivage.infrastructure.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



  //  @Autowired
    //private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Qualifier("userDetailsServiceImpl")
  @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

      auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
       // auth.inMemoryAuthentication().withUser("admin").password(bCryptPasswordEncoder.encode("abcd")).roles("ADMIN").
     // and().withUser("user").password(bCryptPasswordEncoder.encode("abcd")).roles("USER");

    }


   @Override
   public void configure(HttpSecurity http) throws Exception {
       http.csrf().disable();
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       http.authorizeRequests().antMatchers( "/api/users/create-user", "/login", "/actuator/**").permitAll();
       http.authorizeRequests().antMatchers("/contract", "/contract/**", "/category/**").hasAuthority("USER");
       http.authorizeRequests().antMatchers("/account", "/contract/**", "/category/**").hasAnyAuthority("USER", "ADMIN");
       http.authorizeRequests().antMatchers( "/**", "/account").hasAuthority("ADMIN");
       http.authorizeRequests().antMatchers(HttpMethod.PUT, "/**").hasAuthority("ADMIN");
       http.authorizeRequests().anyRequest().authenticated();

    }
        /*
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers( "/api/users/create-user", "/login", "/actuator/**")
                .permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/account/**?**", "/contract/**", "/category/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/articles/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/**").hasAnyAuthority("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


         */
	
	
}
