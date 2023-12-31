package com.ibragimov.apptaskmanagement.security.jwt;

import com.ibragimov.apptaskmanagement.dao.UserRepository;
import com.ibragimov.apptaskmanagement.model.userdetails.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

/**
 * Class JwtRequestFilter implements {@link OncePerRequestFilter} and processes the request and response objects
 * @author Ibragimov Anvar
 * @version 1.0
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    /**
     * @param request  request from client to server with JWT token in header Authorization field
     * @param response  response from server to client with JWT token in header Authorization field
     * @param filterChain  chain of filters that process the request and response objects
     * @throws ServletException  if an error occurs while processing the request or response
     * @throws IOException  if an I/O error occurs while processing the request or response
     */

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            String username = jwtService.getUsernameFromToken(token);
            Optional<User> optionalUser = userRepository.findUserByUsername(username);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication); // set user in SecurityContextHolder
            }
        }

        filterChain.doFilter(request, response);
    }


}
