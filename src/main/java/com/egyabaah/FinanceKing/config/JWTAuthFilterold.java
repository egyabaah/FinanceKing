///**
// * 
// */
//package com.egyabaah.FinanceKing.config;
//
//import java.io.IOException;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
///**
// * @author gyabe
// *
// */
//public class JWTAuthFilterold extends OncePerRequestFilter{
//	
//    private final UserAuthenticationProvider userAuthenticationProvider;
//
//    public JWTAuthFilterold(UserAuthenticationProvider userAuthenticationProvider) {
//        this.userAuthenticationProvider = userAuthenticationProvider;
//    }
//	
//	
//	@Override
//    protected void doFilterInternal(
//            HttpServletRequest httpServletRequest,
//            HttpServletResponse httpServletResponse,
//            FilterChain filterChain) throws ServletException, IOException {
//        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
//
//        if (header != null) {
//            String[] authElements = header.split(" ");
//
//            if (authElements.length == 2
//                    && "Bearer".equals(authElements[0])) {
//                try {
//                    SecurityContextHolder.getContext().setAuthentication(
//                            userAuthenticationProvider.validateToken(authElements[1]));
//                } catch (RuntimeException e) {
//                    SecurityContextHolder.clearContext();
//                    throw e;
//                }
//            }
//        }
//
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
//    }
//
//}