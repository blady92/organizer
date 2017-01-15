package pl.lodz.ftims.pp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class JwtConfiguration {
    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigner(new MacSigner("foobar"));
        tokenConverter.setVerifier(new MacSigner("foobar"));
        return tokenConverter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore(@Autowired JwtAccessTokenConverter tokenConverter) {
        JwtTokenStore tokenStore = new JwtTokenStore(new JwtAccessTokenConverter());
        tokenStore.setTokenEnhancer(tokenConverter);
        return tokenStore;
    }
}
