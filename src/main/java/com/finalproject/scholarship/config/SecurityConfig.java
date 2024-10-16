    package com.finalproject.scholarship.config;




    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.provisioning.InMemoryUserDetailsManager;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests(auth -> auth
                            .requestMatchers("/admin/**").authenticated() // Protect admin routes
                            .anyRequest().permitAll() // Allow all other requests
                    )
                    .formLogin(form -> form
                            .loginPage("/login") // Custom login page
                            .permitAll()
                    )
                    .logout(logout -> logout
                            .permitAll()
                    );

            return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() throws Exception {
            UserDetails admin = User.withDefaultPasswordEncoder()
                    .username("admin")
                    .password("admin")
                    .roles("ADMIN")
                    .build();

            return new InMemoryUserDetailsManager(admin);
        }
    }


