package br.com.itads.conference.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {

	public static Authentication decode(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token != null && token.startsWith("Bearer ")) {
			token = token.substring(7);
			System.out.println("["+token+"]");
			if (token.equals("itads")) {
				return new UsernamePasswordAuthenticationToken("OK", null, null);
			}
		}
		return null;
	}
}
