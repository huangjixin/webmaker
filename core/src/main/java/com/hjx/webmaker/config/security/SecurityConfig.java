package com.hjx.webmaker.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hjx.webmaker.config.security.filter.AuthenticationFilter;
import com.hjx.webmaker.modules.base.utils.TreeHelper;
import com.hjx.webmaker.modules.sys.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参考网址：
 * https://blog.csdn.net/XlxfyzsFdblj/article/details/82083443
 * https://blog.csdn.net/lizc_lizc/article/details/84059004
 * https://blog.csdn.net/XlxfyzsFdblj/article/details/82084183
 * https://blog.csdn.net/weixin_36451151/article/details/83868891
 * 查找了很多文件，有用的还有有的，感谢他们的辛勤付出
 * Security配置文件，项目启动时就加载了
 *
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    @Qualifier(value = "userService")
//    IUserService userServiceDetail;

    @Autowired
    @Qualifier(value = "userService")
    private UserDetailsService userDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/css/**","/images/**","/js/**","/fonts/**","/admin/login","/login.css").permitAll()//都可以访问
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated()//需要相应的角色才能访问
                .and()
                .authenticationProvider(authenticationProvider())
                .httpBasic()
                //未登录时，进行json格式的提示，很喜欢这种写法，不用单独写一个又一个的类
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    PrintWriter out = response.getWriter();
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("code", 403);
                    map.put("message", "未登录");
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })

                .and()
                .authorizeRequests()
                .anyRequest().authenticated() //必须授权才能范围

                .and()
                .formLogin()
                .loginPage("/admin/login") //使用自带的登录
//                .loginProcessingUrl("")
                .permitAll()
                //登录失败，返回json
//                .failureHandler((request, response, ex) -> {
//                    response.setContentType("application/json;charset=utf-8");
//                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                    PrintWriter out = response.getWriter();
//                    Map<String, Object> map = new HashMap<String, Object>();
//                    map.put("code", 401);
//                    if (ex instanceof UsernameNotFoundException || ex instanceof BadCredentialsException) {
//                        map.put("message", "用户名或密码错误");
//                    } else if (ex instanceof DisabledException) {
//                        map.put("message", "账户被禁用");
//                    } else {
//                        map.put("message", "登录失败!");
//                    }
//                    out.write(objectMapper.writeValueAsString(map));
//                    out.flush();
//                    out.close();
//                })
                //登录成功，返回json
//                .successHandler((request, response, authentication) -> {
//                    response.sendRedirect("/admin/index");
//                    /*Map<String, Object> map = new HashMap<String, Object>();
//                    map.put("code", 200);
//                    map.put("message", "登录成功");
//                    map.put("data", authentication);
//                    response.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = response.getWriter();
//                    out.write(objectMapper.writeValueAsString(map));
//                    out.flush();
//                    out.close();*/
//                })
                .and()
                .exceptionHandling()
                //没有权限，返回json
                .accessDeniedHandler((request, response, ex) -> {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    PrintWriter out = response.getWriter();
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("code", 403);
                    map.put("message", "权限不足");
                    out.write(objectMapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                //退出成功，返回json
                .logoutSuccessHandler((request, response, authentication) -> {
                    String header = request.getHeader("X-Requested-With");
                    boolean isAjax = "XMLHttpRequest".equals(header) ? true : false;
                    if (isAjax) {
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("code", 200);
                        map.put("message", "退出成功");
                        map.put("data", authentication);
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write(objectMapper.writeValueAsString(map));
                        out.flush();
                        out.close();
                    } else {
                        response.sendRedirect("/admin/login");
                    }

                })
                .permitAll();
        http.addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        //开启跨域访问
        http.cors().disable().headers().frameOptions().sameOrigin();// 解决iframe无法访问;
        //开启模拟请求，比如API POST测试工具的测试，不开启时，API POST为报403错误
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        //对于在header里面增加token等类似情况，放行所有OPTIONS请求。
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        //对默认的UserDetailsService进行覆盖
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    /* 声明密码的规则 */
    @Bean("bcryptPasswordEncoder")
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

    @Bean
    AuthenticationFilter authenticationFilter() throws Exception {
        AuthenticationFilter filter = new AuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationSuccessHandler((request, response, authentication) -> {
            String header = request.getHeader("X-Requested-With");
            boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;
            if(isAjax){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("code", 200);
                map.put("message", "登录成功");
                map.put("data", authentication);
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write(objectMapper.writeValueAsString(map));
                out.flush();
                out.close();
            }else {
                UserDto userDto = (UserDto) authentication.getPrincipal();
                if (userDto != null) {
                    List permissions = userDto.getPermissions();
                    permissions = TreeHelper.getTreeNodes(permissions);
                    userDto.setMenus(permissions);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
                response.sendRedirect("/admin/index");
            }
        });
        filter.setAuthenticationFailureHandler((request, response, ex) -> {

            String header = request.getHeader("X-Requested-With");
            boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;
            if(isAjax){
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("code", 401);
                if (ex instanceof UsernameNotFoundException || ex instanceof BadCredentialsException) {
                    map.put("message", "用户名或密码错误");
                } else if (ex instanceof DisabledException) {
                    map.put("message", "账户被禁用");
                } else {
                    map.put("message", "登录失败!");
                }
                out.write(objectMapper.writeValueAsString(map));
                out.flush();
                out.close();
            }else{
                response.sendRedirect("/admin/login");
            }
        });

        return filter;
    }
}