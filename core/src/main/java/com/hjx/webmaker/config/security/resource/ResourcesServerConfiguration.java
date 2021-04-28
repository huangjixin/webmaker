package com.hjx.webmaker.config.security.resource;

import com.hjx.webmaker.modules.sys.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.annotation.Resource;


//@Configuration
//@EnableResourceServer
//@Order(-1)
public class ResourcesServerConfiguration extends ResourceServerConfigurerAdapter {
    private static Logger log = LogManager.getLogger(ResourcesServerConfiguration.class);

    @Resource(name = "clientTokenStore")
    public TokenStore tokenStore;

    @Autowired
    @Qualifier(value = "userService")
    IUserService userServiceDetail;

    @Autowired
    AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();

        /*http.authorizeRequests()
                .antMatchers("/admin/css/**","/admin/images/**","/admin/js/**","/fonts/**","/admin/login","/login").permitAll()//都可以访问
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated()//需要相应的角色才能访问
                .and()
                .formLogin()//基于Form表单登录验证
                .loginPage("/admin/login")
                .failureHandler(authenticationFailureHandler)
                .successHandler(authenticationSuccessHandler);*/
//                .loginProcessingUrl()
//                .successForwardUrl("/index")
//                .failureUrl("/login-error");//自定义登录界面

        /*http
                //使用form表单post方式进行登录
                .formLogin()
                //登录页面为自定义的登录页面
                .loginPage("/login")
                //设置登录成功跳转页面，error=true控制页面错误信息的展示
                .successForwardUrl("/admin/index").failureUrl("/login?error=true")
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/admin/*").authenticated()
                //允许不登陆就可以访问的方法，多个用逗号分隔
                .and()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/token", "/admin/login", "/**").permitAll()
                //其他的需要授权后访问
                ;

        //session管理,失效后跳转
        http.sessionManagement().invalidSessionUrl("/login");
        //单用户登录，如果有一个登录了，同一个用户在其他地方登录将前一个剔除下线
        //http.sessionManagement().maximumSessions(1).expiredSessionStrategy(expiredSessionStrategy());
        //单用户登录，如果有一个登录了，同一个用户在其他地方不能登录
        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
        //退出时情况cookies
        http.logout().deleteCookies("JESSIONID");
        //解决中文乱码问题
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        //
        http.addFilterBefore(filter, CsrfFilter.class);*/

        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll();
        /*http
                // Since we want the protected resources to be accessible in the UI as well we need
                // session creation to be allowed (it's disabled by default in 2.0.6)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .requestMatchers().anyRequest()
                .and()
                .anonymous()
                .and()
                .authorizeRequests()
                //                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
                .antMatchers("/ygdxd/**").authenticated();//配置order访问控制，必须认证过后才可以访问*/
        /*http.csrf().disable()
                .authorizeRequests().antMatchers("/admin/**").authenticated()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/token", "/admin/login", "/**").permitAll()
                .and().authorizeRequests()
                .antMatchers("/**").permitAll();*/


        /*http.csrf().disable();
         *//**
         * 基于token, 关闭session
         *//*
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
        *//**
         * 开放资源
         *//*
        http.authorizeRequests().antMatchers(
                "/webjar/**", "/", "/**", "/*.html", "/favicon.ico", "/css/**", "/js/**", "/fonts/**", "/layui/**", "/img/**",
                "/v2/api-docs/**", "/swagger-resources/**", "/webjars/**", "/pages/**", "/druid/**",
                "/statics/**").permitAll().anyRequest().authenticated();*/
        /**
         * 权限配置
         */
        /*http.formLogin().usernameParameter("userNo");
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
        *//*登录页面和登录提交路径*//*
        http.formLogin().usernameParameter("userNo").loginProcessingUrl("/login").successHandler(authenticationSuccessHandler).
                failureHandler(authenticationFailureHandler).and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and().rememberMe();
        http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler).and().rememberMe();
        http.headers().frameOptions().disable();
        http.headers().cacheControl();
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);*/

    }

    /* 资源服务器安全属性配置，与AuthorizationServer授权服务器匹配 */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        log.info("Configuring ResourceServerSecurityConfigurer");
        resources.resourceId("user").tokenStore(tokenStore);
    }

}
