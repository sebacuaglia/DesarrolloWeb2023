package ar.edu.utn.frvm.sistemas.daw2023;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors() // Habilitar CORS
            .and()
            .csrf().disable() // Deshabilitar CSRF (puede ser necesario en una API REST)
            .authorizeRequests()
                .antMatchers("/**").permitAll() // Permitir acceso público a rutas específicas
                .anyRequest().authenticated(); // Todas las demás rutas requieren autenticación+


    }
}