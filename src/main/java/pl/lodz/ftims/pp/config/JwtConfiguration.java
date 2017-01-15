package pl.lodz.ftims.pp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.jwt.crypto.sign.SignerVerifier;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JwtConfiguration {
    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        JwtAccessTokenConverter tokenConverter = new CustomJwtAccessTokenConverter();
        SignerVerifier signerVerifier = new CustomSignerVerifier();
        tokenConverter.setSigner(signerVerifier);
        tokenConverter.setVerifier(signerVerifier);
        return tokenConverter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore(@Autowired JwtAccessTokenConverter tokenConverter) {
        JwtTokenStore tokenStore = new JwtTokenStore(new JwtAccessTokenConverter());
        tokenStore.setTokenEnhancer(tokenConverter);
        return tokenStore;
    }

    private static class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {
        @Override
        public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
            Map<String, Object> customMap = new HashMap<>(map);
            if (customMap.containsKey("iss")) {
                customMap.putIfAbsent("user_name", customMap.get("email"));
                customMap.putIfAbsent("client_id", customMap.get("email"));
                customMap.remove("aud");
            } else {
                customMap.putIfAbsent("user_name", customMap.get("client_id"));
            }
            return super.extractAuthentication(customMap);
        }
    }

    private static class CustomSignerVerifier implements SignerVerifier {

        @Override
        public void verify(byte[] content, byte[] signature) {
        }

        @Override
        public byte[] sign(byte[] bytes) {
            return bytes;
        }

        @Override
        public String algorithm() {
            return "HMACSHA512";
        }
    }
}
