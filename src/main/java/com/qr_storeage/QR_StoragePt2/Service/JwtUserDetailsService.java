package com.qr_storeage.QR_StoragePt2.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        if("javainuse".equals(username)){
            return new User("javainuse", "Password", // TODO: 3/13/2022 find generated security password,
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with the username: " + username);
        }
    }
}