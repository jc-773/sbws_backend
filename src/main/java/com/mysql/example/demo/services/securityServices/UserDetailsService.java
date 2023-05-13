package com.mysql.example.demo.services.securityServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.example.demo.models.User;
import com.mysql.example.demo.repositories.authenticaitonRepositories.UserRepository;
import com.mysql.example.demo.security.UserDetailsImpl;
import com.mysql.example.demo.services.interfaces.securityInterfaces.IUserDetailsService;

@Service
public class UserDetailsService implements IUserDetailsService {
    @Autowired
    UserRepository userRepository;
  
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepository.findByUsername(username)
          .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
  
      return UserDetailsImpl.build(user);
    }
    
}
