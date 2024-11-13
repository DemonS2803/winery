package ru.spmi.winery.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.spmi.winery.entities.Customer;
import ru.spmi.winery.entities.Employee;
import ru.spmi.winery.enums.UserRole;
import ru.spmi.winery.repositories.CustomerRepository;
import ru.spmi.winery.repositories.EmployeeRepository;
import ru.spmi.winery.services.CustomerService;
import ru.spmi.winery.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Customer customer = customerService.getCustomer(login);
        log.info("customer login: " + customer);
        String password = null;
        if (customer != null) {
            authorities.add(new SimpleGrantedAuthority(UserRole.CUSTOMER.toString()));
            password = customer.getPassword();
        }

        Employee employee = employeeService.getEmployee(login);
        log.info("employee login: " + employee);
        if (employee != null) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.toString()));
            password = employee.getPassword();
        }

        log.info("user details: {} {}", login, authorities);
        return new org.springframework.security.core.userdetails.User(login, passwordEncoder.encode(password), true, true, true, true, authorities);
    }

}

