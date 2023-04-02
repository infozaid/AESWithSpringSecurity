package com.example.aeswithspringsecurity.jwt;

import com.example.aeswithspringsecurity.model.User;
import com.example.aeswithspringsecurity.services.UserDetailsServiceImpl;
import com.example.aeswithspringsecurity.util.passwordEncoder.CustomEncoderPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    CustomEncoderPass customEncoderPass;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String userName=authentication.getName();
            User user=  userDetailsService.loadUserOnlyByUsername(userName);
            boolean password= customEncoderPass.matches(authentication.getCredentials().toString().trim(),user.getPassword());
            Authentication auth=null;
            String pass="";
            if(password==true){
               pass= user.getPassword();
            }else{
                throw new UsernameNotFoundException("Incorrect User Name and Password.");
            }


            if (user!=null){
                UserDetails userDetails=userDetailsService.loadUserByUsername(user.getUsername());
                auth=new UsernamePasswordAuthenticationToken(userDetails,pass,userDetails.getAuthorities());
                return auth;
            }else {

                 return null;
            }
        }catch (Exception e){
              throw new UsernameNotFoundException("No user found with username '%s'.");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
