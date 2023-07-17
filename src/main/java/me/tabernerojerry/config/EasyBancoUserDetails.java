package me.tabernerojerry.config;

import lombok.RequiredArgsConstructor;
import me.tabernerojerry.model.Customer;
import me.tabernerojerry.repository.ICustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EasyBancoUserDetails implements UserDetailsService {

    private final ICustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = null;
        List<GrantedAuthority> authorityList = null;
        List<Customer> customerList = customerRepository.findByEmail(username);

        if (customerList.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        } else {
            password = customerList.get(0).getPassword();
            authorityList = new ArrayList<>();
            authorityList.add(new SimpleGrantedAuthority(customerList.get(0).getRole()));
        }

        return new User(username, password, authorityList);
    }

}
