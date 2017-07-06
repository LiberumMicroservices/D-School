//package com.school.data.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    private UserDetailsService userDetailsService;
//
////    @Autowired
////    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .userDetailsService(userDetailsService)
////                .passwordEncoder(getShaPasswordEncoder());
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // включаем защиту от CSRF атак
////        http.csrf()
////                .disable()
////                // указываем правила запросов
////                // по которым будет определятся доступ к ресурсам и остальным данным
////                .authorizeRequests()
////                .antMatchers("/resources/**", "/**").permitAll()
////                .anyRequest().permitAll()
////                .and();
//
////        http.formLogin()
////                // указываем страницу с формой логина
////                .loginPage("/login")
////                // указываем action с формы логина
////                .loginProcessingUrl("/j_spring_security_check")
////                // указываем URL при неудачном логине
////                .failureUrl("/login?error")
////                // Указываем параметры логина и пароля с формы логина
////                .usernameParameter("j_username")
////                .passwordParameter("j_password")
////                // даем доступ к форме логина всем
////                .permitAll();
//
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/resources/**", "/**").permitAll()
//                .anyRequest().permitAll()
//                .antMatchers("/welcome").permitAll()
//                .antMatchers("/admin").hasAnyRole("ROLE_ADMIN");
//
//        http.formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .permitAll();
//
//        http.logout()
//                .permitAll()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//                .invalidateHttpSession(true);
//
//    }
//
//    @Bean
//    public ShaPasswordEncoder getShaPasswordEncoder(){
//        return new ShaPasswordEncoder();
//    }
//
//
//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder encoder(){
//        return new BCryptPasswordEncoder(11);
//    }
//}
