package com.java3.configuration;

/**
 * Created by jon.lynch on 6/24/17.
 *
 * This class is the security configuration for accessing resources
 */
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Default Password Encoder (one-way encryption)
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Main Datasource
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Users query for login
     */
    @Value("${spring.queries.users-query}")
    private String usersQuery;

    /**
     * Roles query for login and roles-based authentication
     */
    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    /**
     * Main configuration method for spring security's authentication
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    /**
     * Main configuration method HTTP access to specific paths and resources
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .antMatchers("/", "/index","/leagues/**","/teams/**", "/team/**", "/schedules", "/about", "/api/v1/game/**").permitAll()
                .antMatchers("/login", "/registration", "/registerUser").permitAll()
                .antMatchers("/admin/users/**", "/admin/leagues/**").hasAuthority("ADMIN")
                .antMatchers("/admin/games/**", "/admin/teams/**").hasAnyAuthority("ADMIN", "LEAGUE_MANAGER")
                .antMatchers("/admin/roster/**").hasAnyAuthority("ADMIN", "CAPTAIN")
                .antMatchers("/admin/profile/**").hasAnyAuthority("ADMIN", "LEAGUE_MANAGER", "CAPTAIN", "PLAYER")
                .anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/admin/index/")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    /**
     * Main configuration method for web security to specific assets
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/fonts/**");
    }

}
