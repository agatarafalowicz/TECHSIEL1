package edu.techsiel1.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

/**
 * Custom JWT token filter for Spring Security.
 * This filter extracts JWT tokens from the Authorization header in incoming requests,
 * validates them, and sets the authentication context based on the token's claims.
 */
public class JWTokenFilter extends OncePerRequestFilter {

    private final String key;

    /**
     * Constructs a JWT token filter with the specified secret key.
     *
     * @param key The secret key used to validate JWT tokens.
     */
    public JWTokenFilter(String key) {
        this.key = key;
    }

    /**
     * Performs the filtering logic for JWT token extraction and authentication.
     *
     * @param request     The HTTP servlet request.
     * @param response    The HTTP servlet response.
     * @param filterChain The filter chain to continue processing the request.
     * @throws ServletException If an error occurs during servlet processing.
     * @throws IOException      If an I/O error occurs.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith(("Bearer"))) {
            String token = authHeader.split(" ")[1];
            Claims claims = Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
            String userId = claims.get("id").toString();
            String userRole = claims.get("role").toString();
            Authentication authentication = new UsernamePasswordAuthenticationToken(userId,
                    null, List.of(new SimpleGrantedAuthority(userRole)));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        filterChain.doFilter(request, response);
    }
}
