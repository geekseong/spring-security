package com.spring.security.sessiosecurityconfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
@Log4j2
public class CustomAuthenticationProvider implements AuthenticationProvider {


    private UserDetailServiceImpl userDetailService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        return null;

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        if (username.equals(userDetails.getUsername()) == false) {

        }


        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
