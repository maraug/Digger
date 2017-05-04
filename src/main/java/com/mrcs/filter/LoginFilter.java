package com.mrcs.filter;

import com.mrcs.domain.User;
import com.mrcs.service.UserService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@WebFilter(filterName = "LoginFilter", value = "/*")
public class LoginFilter implements Filter {

	@Inject
	private UserService userService;

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		User user = null;

		if (request.getSession().getAttribute("user") == null) {
			Principal principal = request.getUserPrincipal();
			if ( principal != null) {
				user = userService.getUserByUsername(principal.getName());
			} else {
				String uuid = getCookieValue(request);
				if (uuid != null) {
					user = userService.getUserByUuid(uuid);
					request.login(user.getUsername(),user.getPassword());
				}
			}
			if (user != null) {
				userService.saveUserInSession(user.getUsername(), request.getSession(true));
			}
		}
		chain.doFilter(req, resp);
	}

	private String getCookieValue(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("DiggerCookie".equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}

}
