package ru.spmi.winery.controllers.rest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.spmi.winery.dto.AuthDTO;
import ru.spmi.winery.entities.Customer;
import ru.spmi.winery.entities.Employee;
import ru.spmi.winery.enums.UserRole;
import ru.spmi.winery.security.JwtUtils;
import ru.spmi.winery.services.CustomerService;
import ru.spmi.winery.services.EmployeeService;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Value("${jwt.time.access-expired}")
    private Integer accessTokenExpirationTime;
    @Value("${jwt.time.refresh-expired}")
    private Integer refreshTokenExpirationTime;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody @Validated AuthDTO loginRequest) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        try {
            log.info("admin: {} user: {}", DigestUtils.sha256Hex("admin"), DigestUtils.sha256Hex("user"));
            if (customerService.loginCustomer(loginRequest.getLogin(), DigestUtils.sha256Hex(loginRequest.getPassword()))) {
                Customer customer = customerService.getCustomer(loginRequest.getLogin());
                authenticateUser(loginRequest.getLogin(), DigestUtils.sha256Hex(loginRequest.getPassword()));
                String accessJwt = jwtUtils.generateJwtToken(customer, accessTokenExpirationTime);
                return new ResponseEntity<>(new AuthDTO("", "", UserRole.CUSTOMER.name(), accessJwt), HttpStatus.ACCEPTED);

            } else if (employeeService.loginEmployee(loginRequest.getLogin(), DigestUtils.sha256Hex(loginRequest.getPassword()))) {
                Employee employee = employeeService.getEmployee(loginRequest.getLogin());
                authenticateUser(loginRequest.getLogin(), DigestUtils.sha256Hex(loginRequest.getPassword()));
                String accessJwt = jwtUtils.generateJwtToken(employee, accessTokenExpirationTime);
                return new ResponseEntity<>(new AuthDTO("", "", UserRole.ADMIN.name(), accessJwt), HttpStatus.ACCEPTED);
            }

            log.warn("invalid login");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            log.warn("invalid login with credentials: " + loginRequest, e);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    public Authentication authenticateUser(String login, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }
}
