package SecuritySpring.SringSecurityTest.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
 @Configuration
 @EnableWebSecurity
 public class Securityconfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return   http
                .csrf(csfr->csfr.disable())
                .authorizeHttpRequests(auth-> {
                    auth.requestMatchers("/utente/**").permitAll();
                    auth.anyRequest().authenticated();
                })    .httpBasic(Customizer.withDefaults())
                .build();
    }


    @Bean // questo bean cripta le password
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean // è un componente fondamentale di Spring Security, utilizzato per gestire il processo di autenticazione degli utenti all'interno dell'applicazione. Viene spesso utilizzato per eseguire operazioni come il controllo delle credenziali e la gestione delle autorizzazioni degli utenti durante il processo di login e autenticazione.
    public AuthenticationManager authManager(UserDetailsService detailsService){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(detailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(daoAuthenticationProvider);
    }

}
