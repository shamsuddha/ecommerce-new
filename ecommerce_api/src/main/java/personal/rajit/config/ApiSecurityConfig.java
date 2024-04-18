package personal.rajit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ApiSecurityConfig {

    private static final String[] AUTH_WHITELIST = {
            "/room/search",
            "/swagger-resources/**",
    };

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(AUTH_WHITELIST).permitAll()
                        .requestMatchers(HttpMethod.GET, "/", "/api/users").permitAll()
                        .requestMatchers(HttpMethod.POST, "/customer/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/expense/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/employee/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/employee-role/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/role/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/payment/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/product/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/product-category/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/purchase/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/purchase-detail/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/sell/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/sell-detail/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/supplier/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/stock/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users/login", "/api/users/{username}").authenticated()
                        .anyRequest().denyAll())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //.addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user1").password("password1").roles("SuperAdmin", "SystemAdmin", "Admin").build();
        return new InMemoryUserDetailsManager(user);
    }
}
