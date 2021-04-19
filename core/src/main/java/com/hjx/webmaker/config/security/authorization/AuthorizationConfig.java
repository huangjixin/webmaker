package com.hjx.webmaker.config.security.authorization;

import com.hjx.webmaker.modules.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 黄记新
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    @Qualifier(value = "userService")
    IUserService userServiceDetail;

    @Qualifier(value = "authPasswordEncoder")
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String ENV_OAUTH = "authentication.oauth.";
    private static final String PROP_CLIENTID = "clientid";
    private static final String PROP_SECRET = "secret";

    /* 客户端信息配置，加载到运行内存 */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("security-service")
                .secret(passwordEncoder().encode("{bcrypt}123456"))
                .scopes("service")
                .autoApprove(true)
                .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code")
                .accessTokenValiditySeconds(12 * 3000 * 1000000);// 5min过期
    }

    /* 端点配置，token存储方式、token配置、用户授权模式等 */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 设置存储方式(JWT)，加密方式，开启密码授权方式
        endpoints.tokenStore(tokenStore())
                .tokenEnhancer(jwtTokenEnhancer())
                .authenticationManager(authenticationServerManagerBean());

        // 执行token刷新需要带上此参数
        endpoints.userDetailsService((UserDetailsService) userServiceDetail);
    }

    /*@Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;*/

    @Bean("authenticationServerManagerBean")
    public AuthenticationManager authenticationServerManagerBean() throws Exception {
        AuthenticationProvider authenticationProvider = this.daoAuthenticationProvider();
        List<AuthenticationProvider> list = new ArrayList<AuthenticationProvider>();
        list.add(authenticationProvider);
        return new ProviderManager(list);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 设置userDetailsService
        provider.setUserDetailsService((UserDetailsService) this.userServiceDetail);
        // 禁止隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        // 使用BCrypt进行密码的hash
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
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

    /* 声明JWT存储方式 */
    @Bean(name = "serverTokenStore")
    @Primary
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtTokenEnhancer());
    }

    /* JWT token生成规则 */
    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        // 根据私钥加锁，客户端需匹配的公钥进行解锁。私钥由Java Keytool生成
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                new ClassPathResource("fzp-jwt.jks"),
                "fzp123".toCharArray());
        // 耦合用户其它信息
        CoreJwtAccessTokenConverter converter = new CoreJwtAccessTokenConverter();
        CoreAccessTokenConverter coreAccessTokenConverter = new CoreAccessTokenConverter();
        CoreUserAuthenticationConverter coreUserAuthenticationConverter = new CoreUserAuthenticationConverter();
//
        coreAccessTokenConverter.setUserTokenConverter(coreUserAuthenticationConverter);
        converter.setAccessTokenConverter(coreAccessTokenConverter);

        // 不耦合用户信息。
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("fzp-jwt"));
        return converter;
    }

    /* 声明安全约束，授权开放配置。 */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
//        oauthServer.allowFormAuthenticationForClients();
    }
}
