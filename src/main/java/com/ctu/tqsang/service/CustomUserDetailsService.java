package com.ctu.tqsang.service;

import com.ctu.tqsang.dao.UserDAO;
import com.ctu.tqsang.domain.CustomUserDetails;
import com.ctu.tqsang.domain.Role;
import com.ctu.tqsang.domain.User;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;
    
    @Override
    public CustomUserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDAO.findOne(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUser(user);
        customUserDetails.setAuthorities(grantedAuthorities);
        return customUserDetails;
    }

}
