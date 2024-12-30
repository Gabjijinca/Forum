package com.example.ProjetoFinal.us;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticServ implements UserDetailsService {

    @Autowired
    private UsuarioRepository reposit;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return reposit.findByLogin(username);
    }
}
