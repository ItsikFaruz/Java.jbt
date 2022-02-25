package app.core.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import app.core.jwt.util.JwtUtil;

public class CustomerFilter implements Filter {

	private JwtUtil jwtUtil;

	public CustomerFilter(JwtUtil jwtUtil) {
		super();
		this.jwtUtil = jwtUtil;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(">>> FILTER");
		// cast the req/resp to http1
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String token = req.getHeader("token");
		String uri = req.getRequestURI();
		if (token != null && !jwtUtil.isTokenExpired(token)) {
			try {
				
				String uriType = jwtUtil.extractClient(token).getClientType().toString();
				
				if (!uri.contains("CUSTOMER") || !uriType.equals("CUSTOMER")) {         
					resp.sendError(HttpStatus.UNAUTHORIZED.value(), "invalid token - go to login");
					return;
				}
					System.out.println(">>> FILTER - valid token");
					// check token validity
					// if valid forward the request to the end point
					chain.doFilter(request, response);
					return;
				
			} catch (Exception e) {
				System.out.println(">>> FILTER - invalid token");
				resp.sendError(HttpStatus.UNAUTHORIZED.value(), "invalid token - go to login");
				return;
			}
		}
		
		System.out.println(">>> FILTER - invalid token");
		// if NOT valid
		// throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "not logged in");
		resp.sendError(HttpStatus.UNAUTHORIZED.value(), "not logged in");
	}

}
