///**
// * 
// */
//package com.egyabaah.FinanceKing.config;
//
//import java.io.IOException;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
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
//public class UsernamePasswordAuthFilter extends OncePerRequestFilter {
//	
//	private static final ObjectMapper MAPPER = new ObjectMapper();
//	private final UserAuthenticationProvider provider;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		if ("v1/signIn".equals(request.getServletPath())) {
//			CredentialsDto credentialsDto = MAPPER.readValue(request.getInputStream(), CredentialsDto.class);
//			
//			try {
//				SecurityContextHolder.getContext().setAuthentication(
//						provider.validateCredentials(credentialsDto)
//						);
//			} catch(RuntimeException e) {
//				SecurityContextHolder.clearContext();
//				throw e;
//			}
//		}
//		
//		filterChain.doFilter(request, response);
//		
//	}
//
//}
