package com.kas.kasproy.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_ADMIN")) {
            redirectStrategy.sendRedirect(request, response, "/management/panel");
        }else if (roles.contains("ROLE_EDITOR")) {
            redirectStrategy.sendRedirect(request, response, "/management/panel");
        } else if (roles.contains("ROLE_USER")) {
            redirectStrategy.sendRedirect(request, response, "/public/home");
        } else {
            throw new IllegalStateException();
        }
    }
}
