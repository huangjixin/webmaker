package com.hjx.webmaker.config.security.authorization;


import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/8/9
 */
public class CoreJwtAccessTokenConverter extends JwtAccessTokenConverter {

    private AccessTokenConverter tokenConverter = new CoreAccessTokenConverter();

    /**
     * @param tokenConverter the tokenConverter to set
     */
    @Override
    public void setAccessTokenConverter(AccessTokenConverter tokenConverter) {
        super.setAccessTokenConverter(tokenConverter);
        this.tokenConverter = tokenConverter;
    }

    /**
     * @return the tokenConverter in use
     */
    @Override
    public AccessTokenConverter getAccessTokenConverter() {
        return tokenConverter;
    }


    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        return tokenConverter.convertAccessToken(token, authentication);
    }

    @Override
    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map) {
        return tokenConverter.extractAccessToken(value, map);
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        return tokenConverter.extractAuthentication(map);
    }

    /*@Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        super.enhance(accessToken,authentication);
        final Map<String, Object> additionalInfo = new HashMap<>();
//        additionalInfo.put("client_name", authentication.getName());
//        additionalInfo.put("ext_name", "irving");
//        User user = (User) authentication.getUserAuthentication().getPrincipal();
//        additionalInfo.put("username", user.getUsername());
//        additionalInfo.put("authorities", user.getAuthorities());

        if(authentication.getUserAuthentication().getPrincipal() instanceof UserDto){
            UserDto userDto = (UserDto)authentication.getUserAuthentication().getPrincipal();
            additionalInfo.put("realName",userDto.getRealName());
        }

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }*/
}
