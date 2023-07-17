package me.tabernerojerry.config;

import lombok.RequiredArgsConstructor;
import me.tabernerojerry.model.Customer;
import me.tabernerojerry.repository.ICustomerRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EasyBancoAuthenticationProvider implements AuthenticationProvider {

    private final ICustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<Customer> customerList = customerRepository.findByEmail(username);

        if (customerList.isEmpty()) {
            throw new BadCredentialsException("Bad credentials");
        } else {
            if (passwordEncoder.matches(password, customerList.get(0).getPassword())) {
                List<GrantedAuthority> authorityList = new ArrayList<>();
                authorityList.add(new SimpleGrantedAuthority(customerList.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username, password, authorityList);
            } else {
                throw new BadCredentialsException("Invalid username or password");
            }
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
