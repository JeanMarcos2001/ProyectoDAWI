package com.biblioLectum.proyectoGrupo02.service.impl;

import com.biblioLectum.proyectoGrupo02.model.Usuario;
import com.biblioLectum.proyectoGrupo02.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repo.findByCorreo(username);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado:"+username);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));

        return new User(
                usuario.getCorreo(),
                usuario.getPassword(),
                usuario.getEstado(),
                true,
                true,
                true,
                roles
        );

    }


}
