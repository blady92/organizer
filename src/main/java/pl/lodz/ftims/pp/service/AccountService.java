package pl.lodz.ftims.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import pl.lodz.ftims.pp.repository.AccountRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AccountService implements UserDetailsService, ClientDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional
                .ofNullable(accountRepository.findByLogin(username))
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found."));
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        if (clientId.endsWith("@gmail.com")) {
            return null;
        }
        return Optional
                .ofNullable(accountRepository.findByLogin(clientId))
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + clientId + " not found."));
    }
}
