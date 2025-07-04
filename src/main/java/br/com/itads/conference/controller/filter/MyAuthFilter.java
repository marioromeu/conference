package br.com.itads.conference.controller.filter;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.itads.conference.util.TokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyAuthFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {

		System.out.println("IN= "+request.getMethod() + " " + request.getRequestURI());
		
		Authentication authentication = TokenUtil.decode(request);		
		if (authentication != null) {
			System.out.println("USER IS VALID");
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} else {
			System.out.println("USER IS INVALID");
		}

		filterChain.doFilter(request, response);
		System.out.println("OUT= "+request.getMethod() + " " + request.getRequestURI());
		
	}

}
