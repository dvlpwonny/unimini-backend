package com.unimini.config;

import com.unimini.security.CustomAuthenticationProvider;
import com.unimini.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private AuthenticationFailureHandler authenticationFailureHandler;
    private AuthenticationSuccessHandler authenticationSuccessHandler;


    /**
     * 규칙설정 메소드
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/uniMap").hasRole("USER")
                .antMatchers("/signIn/**").permitAll()
                .antMatchers("/signUp/**").permitAll()
                .antMatchers("/signOut/**").permitAll()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**", "/unity/**").permitAll() // swagger 예외
                .anyRequest()
                .authenticated()
                
        .and()
            .formLogin()
                .loginPage("/signIn/signInForm")
                .loginProcessingUrl("/signIn/signIn")
                .failureHandler(authenticationFailureHandler)
                .successHandler(authenticationSuccessHandler)
        .and()
            .logout()
                .logoutSuccessUrl("/signIn/signInForm")
                .invalidateHttpSession(true);
    }

    /**
     * 예외처리 메소드
     * @param web
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        		.antMatchers("/mingle/makeMingleEvent")             /* Temp */
        		.antMatchers("/mingle/mingleDetail")        /* Temp */
        		.antMatchers("/mingle/mingleDetail_isLike")        /* Temp */
        		.antMatchers("/mingle/mingleDetail_isIn")        /* Temp */
        		
        		.antMatchers("/mingle/makeMingleEvent_searchPlace") /* Temp */
        		
        		.antMatchers("/c")                   /* Temp */        		
        		.antMatchers("/chat")                /* Temp */        		
        		.antMatchers("/room")                /* Temp */        		
        		.antMatchers("/rooms")               /* Temp */        		
        		.antMatchers("/rooms/**")            /* Temp */        		
        		.antMatchers("/new")                 /* Temp */

                //.antMatchers("/myPage/myPageForm")                 /* Temp */
                //.antMatchers("/myPage/myEventList")                     /* Temp */
                //.antMatchers("/mingle/totalMigleList")                 /* Temp */

                .antMatchers("/unityPage/studentCouncilPage1")
                .antMatchers("/unityPage/studentCouncilPage2")
                .antMatchers("/unityPage/studentCouncilPage3")
                .antMatchers("/unityPage/studentCouncilPage4") // 총학페이지는 security X
                .antMatchers("/resource/**")
                .antMatchers("/static/css/**")
                .antMatchers("/static/iconfont/**")
                .antMatchers("/static/image/**")
                .antMatchers("/static/js/**");

    }



    /**
     * 로그인 인증 처리 메소드
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
