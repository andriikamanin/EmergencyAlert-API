package it.volta.ts.kamaninandrii.EmergencyAlertAPI.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Отключаем CSRF защиту для всех эндпоинтов
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/alerts/**").permitAll()  // Разрешаем доступ ко всем эндпоинтам /api/alerts
                       // .requestMatchers("/messages/**").permitAll()
                        .anyRequest().authenticated()  // Остальные эндпоинты требуют аутентификации
                )
                .formLogin(withDefaults())  // Формируем базовую аутентификацию с использованием формы
                .httpBasic(withDefaults()); // Базовая аутентификация

        return http.build();  // Генерация объекта SecurityFilterChain
    }
}