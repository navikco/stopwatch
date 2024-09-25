package net.kube.land.stopwatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication(scanBasePackages = {"net.kube.land"})
public class AccountsApplication {

    public static String LOCK = "lock";

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountsApplication.class);

    public static void main(String[] args) {

        LOGGER.info(System.getProperty("spring.application.name") + " ::: Spring.Profiles.Active :-> " + System.getProperty("spring.profiles.active"));
        SpringApplication.run(AccountsApplication.class, args);

        LOGGER.info("Started Accounts Microservice...");
    }

    @Configuration
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.authorizeRequests()
                    .anyRequest().permitAll()
                    .and()
                    .csrf().disable();
        }
    }
}
