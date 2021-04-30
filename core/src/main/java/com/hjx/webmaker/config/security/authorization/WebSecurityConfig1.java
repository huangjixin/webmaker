/**
 *
 */
package com.hjx.webmaker.config.security.authorization;

import com.hjx.webmaker.modules.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 黄记新
 *
 */
//@Configuration
//@EnableWebSecurity
//@Order(1)
public class WebSecurityConfig1 extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(value = "userService")
    IUserService userServiceDetail;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /* http自定义配置 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll();
        /*http.csrf().disable()
                .authorizeRequests().antMatchers("/admin/**").authenticated()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/oauth/token", "/oauth/check_token", "/swagger-ui.html", "/swagger-resources/**",
                        "/v2/api-docs", "/**").permitAll();*/
        // 放行的请求
                /*.antMatchers(
                        "/login/**",
                        // Oauth2
                        "/oauth/token",
                        // swagger
                        "/swagger-ui.html",
                        "/webjars/springfox-swagger-ui/**",
                        "/swagger-resources/**",
                        "/v2/api-docs"
                ).permitAll()
                // 其他所有请求，需要认证
                .anyRequest().authenticated();*/
    }

    /* 认证管理器配置 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* 配置UserDetailsService及密码规则 */
        auth.userDetailsService((UserDetailsService) userServiceDetail).passwordEncoder(this.passwordEncoder());
//        auth.inMemoryAuthentication().
//                passwordEncoder(passwordEncoder()).
//                withUser("admin").password("123456").roles("ADMIN");
    }

    @Bean("authPasswordEncoder")
    public PasswordEncoder passwordEncoder() {
        String idForEncode = "bcrypt";
        Map encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("sha256", new StandardPasswordEncoder());
        PasswordEncoder passwordEncoder =
                new DelegatingPasswordEncoder(idForEncode, encoders);
        return passwordEncoder;
    }

    /* 声明密码的规则 */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String content = "security-service:{bcrypt}123456";
        String encodeContent = Base64.getEncoder().encodeToString(content.getBytes());
        System.out.println(encodeContent);
    }
}
