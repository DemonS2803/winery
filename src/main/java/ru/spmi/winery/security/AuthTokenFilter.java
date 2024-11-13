package ru.spmi.winery.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.spmi.winery.repositories.CustomerRepository;
import ru.spmi.winery.repositories.EmployeeRepository;
import ru.spmi.winery.services.CustomerService;
import ru.spmi.winery.services.EmployeeService;

import java.io.IOException;

@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;




    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
//            log.info("got jwt {} for uri {}", jwt, request.getRequestURI());
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String userLogin = String.valueOf(jwtUtils.getUserLoginFromToken(jwt));
                UserDetails userDetails = userDetailsService.loadUserByUsername(userLogin);
//                log.info("user login {}", userLogin);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                log.info("authenticated user {}", userLogin);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                log.info("authentication set details");
                SecurityContextHolder.getContext().setAuthentication(authentication);
//                SecurityContextHolder.getContext().getAuthentication().setAuthenticated(true);
                log.info("security context set {}", SecurityContextHolder.getContext().getAuthentication());
            }
        } catch (Exception e) {
//            log.error("Cannot set user authentication: {}", e.getMessage());
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        if (request.getParameter("token") != null) {
            return request.getParameter("token");
        }
        return headerAuth;
    }
}
