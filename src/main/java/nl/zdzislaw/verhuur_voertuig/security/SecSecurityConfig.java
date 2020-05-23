package nl.zdzislaw.verhuur_voertuig.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> builder=auth.jdbcAuthentication();
        builder.dataSource(dataSource);
        JdbcUserDetailsManager userDetailsManager=builder.getUserDetailsService();
        userDetailsManager.setUsersByUsernameQuery("SELECT Username, Password, Enabled FROM User WHERE Username=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT Username, RoleName FROM User WHERE Username=?");
        userDetailsManager.setCreateUserSql("INSERT INTO User (FirstName, LastName, DateOfBirth, Username, Password, RegisterDate, Role_Name, Enabled) VALUES (?,?,?,?,?,?,?,?)");
       userDetailsManager.setCreateAuthoritySql("INSERT INTO User(Username, RoleName) VALUES (?,?)");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/registerProcess").permitAll()
                .antMatchers("/registerSuccess").permitAll()
                .antMatchers("https://www.europcar.nl/*").permitAll()
              /*  .antMatchers("/admin/*").hasRole("ADMIN")*/
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/loginform")
                .permitAll()
                .loginProcessingUrl("/processlogin")
                .defaultSuccessUrl("/home",true)
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logmeout")
                .logoutSuccessUrl("/")
                .permitAll();

    }
    @Bean
public PasswordEncoder passwordEncoder(){
    PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
    return passwordEncoder;
    }
}
